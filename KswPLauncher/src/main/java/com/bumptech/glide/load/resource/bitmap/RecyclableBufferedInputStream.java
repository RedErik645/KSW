package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] buf;
    private final ArrayPool byteArrayPool;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    public RecyclableBufferedInputStream(InputStream in, ArrayPool byteArrayPool2) {
        this(in, byteArrayPool2, 65536);
    }

    RecyclableBufferedInputStream(InputStream in, ArrayPool byteArrayPool2, int bufferSize) {
        super(in);
        this.markpos = -1;
        this.byteArrayPool = byteArrayPool2;
        this.buf = (byte[]) byteArrayPool2.get(bufferSize, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream localIn;
        localIn = this.in;
        if (this.buf == null || localIn == null) {
            throw streamClosed();
        }
        return (this.count - this.pos) + localIn.available();
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void fixMarkLimit() {
        this.marklimit = this.buf.length;
    }

    public synchronized void release() {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
        InputStream localIn = this.in;
        this.in = null;
        if (localIn != null) {
            localIn.close();
        }
    }

    private int fillbuf(InputStream localIn, byte[] localBuf) throws IOException {
        int i;
        int i2 = this.markpos;
        if (i2 == -1 || this.pos - i2 >= (i = this.marklimit)) {
            int result = localIn.read(localBuf);
            if (result > 0) {
                this.markpos = -1;
                this.pos = 0;
                this.count = result;
            }
            return result;
        }
        if (i2 == 0 && i > localBuf.length && this.count == localBuf.length) {
            int newLength = localBuf.length * 2;
            if (newLength > i) {
                newLength = this.marklimit;
            }
            byte[] newbuf = (byte[]) this.byteArrayPool.get(newLength, byte[].class);
            System.arraycopy(localBuf, 0, newbuf, 0, localBuf.length);
            this.buf = newbuf;
            localBuf = newbuf;
            this.byteArrayPool.put(localBuf);
        } else if (i2 > 0) {
            System.arraycopy(localBuf, i2, localBuf, 0, localBuf.length - i2);
        }
        int i3 = this.pos - this.markpos;
        this.pos = i3;
        this.markpos = 0;
        this.count = 0;
        int bytesread = localIn.read(localBuf, i3, localBuf.length - i3);
        int i4 = this.pos;
        if (bytesread > 0) {
            i4 += bytesread;
        }
        this.count = i4;
        return bytesread;
    }

    public synchronized void mark(int readlimit) {
        this.marklimit = Math.max(this.marklimit, readlimit);
        this.markpos = this.pos;
    }

    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] localBuf = this.buf;
        InputStream localIn = this.in;
        if (localBuf == null || localIn == null) {
            throw streamClosed();
        } else if (this.pos >= this.count && fillbuf(localIn, localBuf) == -1) {
            return -1;
        } else {
            if (localBuf == this.buf || (localBuf = this.buf) != null) {
                int i = this.count;
                int i2 = this.pos;
                if (i - i2 <= 0) {
                    return -1;
                }
                this.pos = i2 + 1;
                return localBuf[i2] & UByte.MAX_VALUE;
            }
            throw streamClosed();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] buffer, int offset, int byteCount) throws IOException {
        int required;
        int read;
        byte[] localBuf = this.buf;
        if (localBuf == null) {
            throw streamClosed();
        } else if (byteCount == 0) {
            return 0;
        } else {
            InputStream localIn = this.in;
            if (localIn != null) {
                int i = this.pos;
                int i2 = this.count;
                if (i < i2) {
                    int copylength = i2 - i >= byteCount ? byteCount : i2 - i;
                    System.arraycopy(localBuf, i, buffer, offset, copylength);
                    this.pos += copylength;
                    if (copylength == byteCount || localIn.available() == 0) {
                        return copylength;
                    }
                    offset += copylength;
                    required = byteCount - copylength;
                } else {
                    required = byteCount;
                }
                while (true) {
                    int i3 = -1;
                    if (this.markpos == -1 && required >= localBuf.length) {
                        read = localIn.read(buffer, offset, required);
                        if (read == -1) {
                            if (required != byteCount) {
                                i3 = byteCount - required;
                            }
                            return i3;
                        }
                    } else if (fillbuf(localIn, localBuf) == -1) {
                        if (required != byteCount) {
                            i3 = byteCount - required;
                        }
                        return i3;
                    } else if (localBuf == this.buf || (localBuf = this.buf) != null) {
                        int i4 = this.count;
                        int i5 = this.pos;
                        read = i4 - i5 >= required ? required : i4 - i5;
                        System.arraycopy(localBuf, i5, buffer, offset, read);
                        this.pos += read;
                    } else {
                        throw streamClosed();
                    }
                    required -= read;
                    if (required == 0) {
                        return byteCount;
                    }
                    if (localIn.available() == 0) {
                        return byteCount - required;
                    }
                    offset += read;
                }
            } else {
                throw streamClosed();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.buf != null) {
            int i = this.markpos;
            if (-1 != i) {
                this.pos = i;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long byteCount) throws IOException {
        if (byteCount < 1) {
            return 0;
        }
        byte[] localBuf = this.buf;
        if (localBuf != null) {
            InputStream localIn = this.in;
            if (localIn != null) {
                int i = this.count;
                int i2 = this.pos;
                if (((long) (i - i2)) >= byteCount) {
                    this.pos = (int) (((long) i2) + byteCount);
                    return byteCount;
                }
                long read = ((long) i) - ((long) i2);
                this.pos = i;
                if (this.markpos == -1 || byteCount > ((long) this.marklimit)) {
                    return localIn.skip(byteCount - read) + read;
                } else if (fillbuf(localIn, localBuf) == -1) {
                    return read;
                } else {
                    int i3 = this.count;
                    int i4 = this.pos;
                    if (((long) (i3 - i4)) >= byteCount - read) {
                        this.pos = (int) ((((long) i4) + byteCount) - read);
                        return byteCount;
                    }
                    long read2 = (((long) i3) + read) - ((long) i4);
                    this.pos = i3;
                    return read2;
                }
            } else {
                throw streamClosed();
            }
        } else {
            throw streamClosed();
        }
    }

    /* access modifiers changed from: package-private */
    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String detailMessage) {
            super(detailMessage);
        }
    }
}
