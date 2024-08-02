package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.UByte;

public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = StandardGifDecoder.class.getSimpleName();
    private int[] act;
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(GifDecoder.BitmapProvider provider, GifHeader gifHeader, ByteBuffer rawData2) {
        this(provider, gifHeader, rawData2, 1);
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider provider, GifHeader gifHeader, ByteBuffer rawData2, int sampleSize2) {
        this(provider);
        setData(gifHeader, rawData2, sampleSize2);
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider provider) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = provider;
        this.header = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.header.height;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int n) {
        if (n < 0 || n >= this.header.frameCount) {
            return -1;
        }
        return this.header.frames.get(n).delay;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        int i;
        if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        if (this.header.loopCount == 0) {
            return 0;
        }
        return this.header.loopCount + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            String str = TAG;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer);
            }
            this.status = 1;
        }
        int i = this.status;
        if (i != 1) {
            if (i != 2) {
                this.status = 0;
                if (this.block == null) {
                    this.block = this.bitmapProvider.obtainByteArray(255);
                }
                GifFrame currentFrame = this.header.frames.get(this.framePointer);
                GifFrame previousFrame = null;
                int previousIndex = this.framePointer - 1;
                if (previousIndex >= 0) {
                    previousFrame = this.header.frames.get(previousIndex);
                }
                int[] iArr = currentFrame.lct != null ? currentFrame.lct : this.header.gct;
                this.act = iArr;
                if (iArr == null) {
                    String str2 = TAG;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.framePointer);
                    }
                    this.status = 1;
                    return null;
                }
                if (currentFrame.transparency) {
                    int[] iArr2 = this.act;
                    System.arraycopy(iArr2, 0, this.pct, 0, iArr2.length);
                    int[] iArr3 = this.pct;
                    this.act = iArr3;
                    iArr3[currentFrame.transIndex] = 0;
                }
                return setPixels(currentFrame, previousFrame);
            }
        }
        String str3 = TAG;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.status);
        }
        return null;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(InputStream is, int contentLength) {
        if (is != null) {
            try {
                ByteArrayOutputStream buffer = new ByteArrayOutputStream(contentLength > 0 ? contentLength + 4096 : 16384);
                byte[] data = new byte[16384];
                while (true) {
                    int nRead = is.read(data, 0, data.length);
                    if (nRead == -1) {
                        break;
                    }
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();
                read(buffer.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (is != null) {
            try {
                is.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(GifHeader header2, byte[] data) {
        setData(header2, ByteBuffer.wrap(data));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(GifHeader header2, ByteBuffer buffer) {
        setData(header2, buffer, 1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(GifHeader header2, ByteBuffer buffer, int sampleSize2) {
        if (sampleSize2 > 0) {
            int sampleSize3 = Integer.highestOneBit(sampleSize2);
            this.status = 0;
            this.header = header2;
            this.framePointer = -1;
            ByteBuffer asReadOnlyBuffer = buffer.asReadOnlyBuffer();
            this.rawData = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.savePrevious = false;
            Iterator<GifFrame> it = header2.frames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
            this.sampleSize = sampleSize3;
            this.downsampledWidth = header2.width / sampleSize3;
            this.downsampledHeight = header2.height / sampleSize3;
            this.mainPixels = this.bitmapProvider.obtainByteArray(header2.width * header2.height);
            this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + sampleSize2);
        }
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(byte[] data) {
        GifHeader parseHeader = getHeaderParser().setData(data).parseHeader();
        this.header = parseHeader;
        if (data != null) {
            setData(parseHeader, data);
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    private Bitmap setPixels(GifFrame currentFrame, GifFrame previousFrame) {
        Bitmap bitmap;
        int[] dest = this.mainScratch;
        if (previousFrame == null) {
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                this.bitmapProvider.release(bitmap2);
            }
            this.previousImage = null;
            Arrays.fill(dest, 0);
        }
        if (previousFrame != null && previousFrame.dispose == 3 && this.previousImage == null) {
            Arrays.fill(dest, 0);
        }
        if (previousFrame != null && previousFrame.dispose > 0) {
            if (previousFrame.dispose == 2) {
                int c = 0;
                if (!currentFrame.transparency) {
                    c = this.header.bgColor;
                    if (currentFrame.lct != null && this.header.bgIndex == currentFrame.transIndex) {
                        c = 0;
                    }
                } else if (this.framePointer == 0) {
                    this.isFirstFrameTransparent = true;
                }
                int downsampledIH = previousFrame.ih / this.sampleSize;
                int downsampledIY = previousFrame.iy / this.sampleSize;
                int downsampledIW = previousFrame.iw / this.sampleSize;
                int downsampledIX = previousFrame.ix / this.sampleSize;
                int i = this.downsampledWidth;
                int topLeft = (downsampledIY * i) + downsampledIX;
                int bottomLeft = (i * downsampledIH) + topLeft;
                int left = topLeft;
                while (left < bottomLeft) {
                    int right = left + downsampledIW;
                    for (int pointer = left; pointer < right; pointer++) {
                        dest[pointer] = c;
                    }
                    left += this.downsampledWidth;
                }
            } else if (previousFrame.dispose == 3 && (bitmap = this.previousImage) != null) {
                int i2 = this.downsampledWidth;
                bitmap.getPixels(dest, 0, i2, 0, 0, i2, this.downsampledHeight);
            }
        }
        decodeBitmapData(currentFrame);
        if (currentFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(currentFrame);
        } else {
            copyIntoScratchFast(currentFrame);
        }
        if (this.savePrevious && (currentFrame.dispose == 0 || currentFrame.dispose == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap3 = this.previousImage;
            int i3 = this.downsampledWidth;
            bitmap3.setPixels(dest, 0, i3, 0, 0, i3, this.downsampledHeight);
        }
        Bitmap result = getNextBitmap();
        int i4 = this.downsampledWidth;
        result.setPixels(dest, 0, i4, 0, 0, i4, this.downsampledHeight);
        return result;
    }

    /* JADX INFO: Multiple debug info for r3v3 byte: [D('byteCurrentColorIndex' byte), D('downsampledIH' int)] */
    /* JADX INFO: Multiple debug info for r4v3 int: [D('downsampledIY' int), D('currentColorIndex' int)] */
    private void copyIntoScratchFast(GifFrame currentFrame) {
        GifFrame gifFrame = currentFrame;
        int[] dest = this.mainScratch;
        int downsampledIH = gifFrame.ih;
        int downsampledIY = gifFrame.iy;
        int downsampledIW = gifFrame.iw;
        int downsampledIX = gifFrame.ix;
        boolean isFirstFrame = this.framePointer == 0;
        int width = this.downsampledWidth;
        byte[] mainPixels2 = this.mainPixels;
        int[] act2 = this.act;
        byte transparentColorIndex = -1;
        int i = 0;
        while (i < downsampledIH) {
            int k = (i + downsampledIY) * width;
            int dx = k + downsampledIX;
            int dlim = dx + downsampledIW;
            if (k + width < dlim) {
                dlim = k + width;
            }
            int sx = gifFrame.iw * i;
            int dx2 = dx;
            while (dx2 < dlim) {
                byte byteCurrentColorIndex = mainPixels2[sx];
                int currentColorIndex = byteCurrentColorIndex & UByte.MAX_VALUE;
                if (currentColorIndex != transparentColorIndex) {
                    int color = act2[currentColorIndex];
                    if (color != 0) {
                        dest[dx2] = color;
                    } else {
                        transparentColorIndex = byteCurrentColorIndex;
                    }
                }
                sx++;
                dx2++;
                downsampledIH = downsampledIH;
                downsampledIY = downsampledIY;
            }
            i++;
            gifFrame = currentFrame;
        }
        this.isFirstFrameTransparent = Boolean.valueOf(this.isFirstFrameTransparent == null && isFirstFrame && transparentColorIndex != -1);
    }

    /* JADX INFO: Multiple debug info for r4v5 int: [D('downsampledIY' int), D('dlim' int)] */
    private void copyCopyIntoScratchRobust(GifFrame currentFrame) {
        boolean z;
        int downsampledIX;
        int downsampledIW;
        int downsampledIY;
        int[] dest = this.mainScratch;
        int downsampledIH = currentFrame.ih / this.sampleSize;
        int downsampledIY2 = currentFrame.iy / this.sampleSize;
        int downsampledIW2 = currentFrame.iw / this.sampleSize;
        int downsampledIX2 = currentFrame.ix / this.sampleSize;
        int iline = 0;
        boolean isFirstFrame = this.framePointer == 0;
        int sampleSize2 = this.sampleSize;
        int downsampledWidth2 = this.downsampledWidth;
        int downsampledHeight2 = this.downsampledHeight;
        byte[] mainPixels2 = this.mainPixels;
        int[] act2 = this.act;
        int pass = 1;
        Boolean isFirstFrameTransparent2 = this.isFirstFrameTransparent;
        int inc = 8;
        int i = 0;
        while (i < downsampledIH) {
            int line = i;
            boolean isFirstFrameTransparent3 = isFirstFrameTransparent2;
            if (currentFrame.interlace) {
                if (iline >= downsampledIH) {
                    pass++;
                    switch (pass) {
                        case 2:
                            iline = 4;
                            break;
                        case 3:
                            iline = 2;
                            inc = 4;
                            break;
                        case 4:
                            iline = 1;
                            inc = 2;
                            break;
                    }
                }
                line = iline;
                iline += inc;
            }
            int line2 = line + downsampledIY2;
            boolean isNotDownsampling = sampleSize2 == 1;
            if (line2 < downsampledHeight2) {
                int k = line2 * downsampledWidth2;
                int dx = k + downsampledIX2;
                downsampledIY = downsampledIY2;
                int dlim = dx + downsampledIW2;
                downsampledIW = downsampledIW2;
                if (k + downsampledWidth2 < dlim) {
                    dlim = k + downsampledWidth2;
                }
                downsampledIX = downsampledIX2;
                int sx = i * sampleSize2 * currentFrame.iw;
                if (isNotDownsampling) {
                    int dx2 = dx;
                    while (dx2 < dlim) {
                        int averageColor = act2[mainPixels2[sx] & UByte.MAX_VALUE];
                        if (averageColor != 0) {
                            dest[dx2] = averageColor;
                        } else if (isFirstFrame && isFirstFrameTransparent3 == null) {
                            isFirstFrameTransparent3 = true;
                        }
                        sx += sampleSize2;
                        dx2++;
                        isNotDownsampling = isNotDownsampling;
                    }
                    isFirstFrameTransparent2 = isFirstFrameTransparent3;
                } else {
                    int maxPositionInSource = ((dlim - dx) * sampleSize2) + sx;
                    int dx3 = dx;
                    while (dx3 < dlim) {
                        int averageColor2 = averageColorsNear(sx, maxPositionInSource, currentFrame.iw);
                        if (averageColor2 != 0) {
                            dest[dx3] = averageColor2;
                        } else if (isFirstFrame && isFirstFrameTransparent3 == null) {
                            isFirstFrameTransparent3 = true;
                        }
                        sx += sampleSize2;
                        dx3++;
                        dlim = dlim;
                    }
                    isFirstFrameTransparent2 = isFirstFrameTransparent3;
                }
            } else {
                downsampledIY = downsampledIY2;
                downsampledIW = downsampledIW2;
                downsampledIX = downsampledIX2;
                isFirstFrameTransparent2 = isFirstFrameTransparent3;
            }
            i++;
            downsampledIH = downsampledIH;
            downsampledIY2 = downsampledIY;
            downsampledIW2 = downsampledIW;
            downsampledIX2 = downsampledIX;
        }
        if (this.isFirstFrameTransparent == null) {
            if (isFirstFrameTransparent2 == null) {
                z = false;
            } else {
                z = isFirstFrameTransparent2.booleanValue();
            }
            this.isFirstFrameTransparent = Boolean.valueOf(z);
        }
    }

    private int averageColorsNear(int positionInMainPixels, int maxPositionInMainPixels, int currentFrameIw) {
        int alphaSum = 0;
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;
        int totalAdded = 0;
        for (int i = positionInMainPixels; i < this.sampleSize + positionInMainPixels; i++) {
            byte[] bArr = this.mainPixels;
            if (i >= bArr.length || i >= maxPositionInMainPixels) {
                break;
            }
            int currentColor = this.act[bArr[i] & UByte.MAX_VALUE];
            if (currentColor != 0) {
                alphaSum += (currentColor >> 24) & 255;
                redSum += (currentColor >> 16) & 255;
                greenSum += (currentColor >> 8) & 255;
                blueSum += currentColor & 255;
                totalAdded++;
            }
        }
        for (int i2 = positionInMainPixels + currentFrameIw; i2 < positionInMainPixels + currentFrameIw + this.sampleSize; i2++) {
            byte[] bArr2 = this.mainPixels;
            if (i2 >= bArr2.length || i2 >= maxPositionInMainPixels) {
                break;
            }
            int currentColor2 = this.act[bArr2[i2] & UByte.MAX_VALUE];
            if (currentColor2 != 0) {
                alphaSum += (currentColor2 >> 24) & 255;
                redSum += (currentColor2 >> 16) & 255;
                greenSum += (currentColor2 >> 8) & 255;
                blueSum += currentColor2 & 255;
                totalAdded++;
            }
        }
        if (totalAdded == 0) {
            return 0;
        }
        return ((alphaSum / totalAdded) << 24) | ((redSum / totalAdded) << 16) | ((greenSum / totalAdded) << 8) | (blueSum / totalAdded);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x0109 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: short[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void decodeBitmapData(GifFrame frame) {
        int i;
        int i2;
        int pi;
        int i3;
        int first;
        StandardGifDecoder standardGifDecoder = this;
        if (frame != null) {
            standardGifDecoder.rawData.position(frame.bufferFrameStart);
        }
        if (frame == null) {
            i2 = standardGifDecoder.header.width;
            i = standardGifDecoder.header.height;
        } else {
            i2 = frame.iw;
            i = frame.ih;
        }
        int npix = i2 * i;
        byte[] bArr = standardGifDecoder.mainPixels;
        if (bArr == null || bArr.length < npix) {
            standardGifDecoder.mainPixels = standardGifDecoder.bitmapProvider.obtainByteArray(npix);
        }
        byte[] mainPixels2 = standardGifDecoder.mainPixels;
        if (standardGifDecoder.prefix == null) {
            standardGifDecoder.prefix = new short[4096];
        }
        short[] prefix2 = standardGifDecoder.prefix;
        if (standardGifDecoder.suffix == null) {
            standardGifDecoder.suffix = new byte[4096];
        }
        byte[] suffix2 = standardGifDecoder.suffix;
        if (standardGifDecoder.pixelStack == null) {
            standardGifDecoder.pixelStack = new byte[4097];
        }
        byte[] pixelStack2 = standardGifDecoder.pixelStack;
        int dataSize = readByte();
        int clear = 1 << dataSize;
        int endOfInformation = clear + 1;
        int available = clear + 2;
        int oldCode = -1;
        int codeSize = dataSize + 1;
        int codeMask = (1 << codeSize) - 1;
        int code = 0;
        while (true) {
            pi = 0;
            if (code >= clear) {
                break;
            }
            prefix2[code] = 0;
            suffix2[code] = (byte) code;
            code++;
        }
        byte[] block2 = standardGifDecoder.block;
        int bi = 0;
        int top = 0;
        int first2 = 0;
        int count = 0;
        int bits = 0;
        int datum = 0;
        int bits2 = 0;
        while (true) {
            if (bits2 >= npix) {
                break;
            }
            if (count == 0) {
                count = readBlock();
                if (count <= 0) {
                    standardGifDecoder.status = 3;
                    break;
                } else {
                    i3 = bits2;
                    bi = 0;
                }
            } else {
                i3 = bits2;
            }
            datum += (block2[bi] & UByte.MAX_VALUE) << bits;
            bi++;
            count--;
            int first3 = first2;
            int bits3 = bits + 8;
            while (true) {
                if (bits3 < codeSize) {
                    standardGifDecoder = this;
                    bits = bits3;
                    bits2 = i3;
                    first2 = first3;
                    break;
                }
                short code2 = datum & codeMask;
                datum >>= codeSize;
                bits3 -= codeSize;
                if (code2 == clear) {
                    codeSize = dataSize + 1;
                    codeMask = (1 << codeSize) - 1;
                    available = clear + 2;
                    oldCode = -1;
                } else if (code2 == endOfInformation) {
                    bits = bits3;
                    bits2 = i3;
                    first2 = first3;
                    standardGifDecoder = this;
                    break;
                } else if (oldCode == -1) {
                    mainPixels2[pi] = suffix2[code2];
                    pi++;
                    i3++;
                    oldCode = code2;
                    first3 = code2;
                    block2 = block2;
                } else {
                    if (code2 >= available) {
                        first = first3;
                        pixelStack2[top] = (byte) first;
                        top++;
                        code2 = oldCode;
                    } else {
                        first = first3;
                    }
                    while (code2 >= clear) {
                        pixelStack2[top] = suffix2[code2];
                        top++;
                        code2 = prefix2[code2];
                    }
                    int first4 = suffix2[code2] & UByte.MAX_VALUE;
                    mainPixels2[pi] = (byte) first4;
                    pi++;
                    i3++;
                    while (top > 0) {
                        top--;
                        mainPixels2[pi] = pixelStack2[top];
                        pi++;
                        i3++;
                    }
                    if (available < 4096) {
                        prefix2[available] = (short) oldCode;
                        suffix2[available] = (byte) first4;
                        available++;
                        if ((available & codeMask) == 0) {
                            if (available < 4096) {
                                codeSize++;
                                codeMask += available;
                            }
                        }
                    }
                    oldCode = code2;
                    first3 = first4;
                    block2 = block2;
                }
            }
        }
        Arrays.fill(mainPixels2, pi, npix, (byte) 0);
    }

    private int readByte() {
        return this.rawData.get() & UByte.MAX_VALUE;
    }

    private int readBlock() {
        int blockSize = readByte();
        if (blockSize <= 0) {
            return blockSize;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(blockSize, byteBuffer.remaining()));
        return blockSize;
    }

    private Bitmap getNextBitmap() {
        Boolean bool = this.isFirstFrameTransparent;
        Bitmap result = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        result.setHasAlpha(true);
        return result;
    }
}
