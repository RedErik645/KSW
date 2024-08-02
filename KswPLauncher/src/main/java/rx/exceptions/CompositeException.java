package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    @Deprecated
    public CompositeException(String messagePrefix, Collection<? extends Throwable> errors) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<Throwable> localExceptions = new ArrayList<>();
        if (errors != null) {
            for (Throwable ex : errors) {
                if (ex instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) ex).getExceptions());
                } else if (ex != null) {
                    linkedHashSet.add(ex);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        localExceptions.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(localExceptions);
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }

    public CompositeException(Collection<? extends Throwable> errors) {
        this(null, errors);
    }

    public CompositeException(Throwable... errors) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<Throwable> localExceptions = new ArrayList<>();
        if (errors != null) {
            for (Throwable ex : errors) {
                if (ex instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) ex).getExceptions());
                } else if (ex != null) {
                    linkedHashSet.add(ex);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        localExceptions.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(localExceptions);
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    public String getMessage() {
        return this.message;
    }

    public synchronized Throwable getCause() {
        if (this.cause == null) {
            Throwable localCause = new CompositeExceptionCausalChain();
            Set<Throwable> seenCauses = new HashSet<>();
            Throwable chain = localCause;
            Iterator i$ = this.exceptions.iterator();
            while (i$.hasNext()) {
                Throwable e = i$.next();
                if (!seenCauses.contains(e)) {
                    seenCauses.add(e);
                    for (Throwable child : getListOfCauses(e)) {
                        if (seenCauses.contains(child)) {
                            e = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            seenCauses.add(child);
                        }
                    }
                    try {
                        chain.initCause(e);
                    } catch (Throwable th) {
                    }
                    chain = getRootCause(chain);
                }
            }
            this.cause = localCause;
        }
        return this.cause;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream s) {
        printStackTrace(new WrappedPrintStream(s));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter s) {
        printStackTrace(new WrappedPrintWriter(s));
    }

    private void printStackTrace(PrintStreamOrWriter s) {
        StringBuilder bldr = new StringBuilder(128);
        bldr.append(this).append('\n');
        for (StackTraceElement myStackElement : getStackTrace()) {
            bldr.append("\tat ").append(myStackElement).append('\n');
        }
        int i = 1;
        for (Throwable ex : this.exceptions) {
            bldr.append("  ComposedException ").append(i).append(" :\n");
            appendStackTrace(bldr, ex, "\t");
            i++;
        }
        synchronized (s.lock()) {
            s.println(bldr.toString());
        }
    }

    private void appendStackTrace(StringBuilder bldr, Throwable ex, String prefix) {
        bldr.append(prefix).append(ex).append('\n');
        for (StackTraceElement stackElement : ex.getStackTrace()) {
            bldr.append("\t\tat ").append(stackElement).append('\n');
        }
        if (ex.getCause() != null) {
            bldr.append("\tCaused by: ");
            appendStackTrace(bldr, ex.getCause(), "");
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class PrintStreamOrWriter {
        /* access modifiers changed from: package-private */
        public abstract Object lock();

        /* access modifiers changed from: package-private */
        public abstract void println(Object obj);

        PrintStreamOrWriter() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        WrappedPrintStream(PrintStream printStream2) {
            this.printStream = printStream2;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.exceptions.CompositeException.PrintStreamOrWriter
        public Object lock() {
            return this.printStream;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.exceptions.CompositeException.PrintStreamOrWriter
        public void println(Object o) {
            this.printStream.println(o);
        }
    }

    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        WrappedPrintWriter(PrintWriter printWriter2) {
            this.printWriter = printWriter2;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.exceptions.CompositeException.PrintStreamOrWriter
        public Object lock() {
            return this.printWriter;
        }

        /* access modifiers changed from: package-private */
        @Override // rx.exceptions.CompositeException.PrintStreamOrWriter
        public void println(Object o) {
            this.printWriter.println(o);
        }
    }

    static final class CompositeExceptionCausalChain extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        CompositeExceptionCausalChain() {
        }

        public String getMessage() {
            return MESSAGE;
        }
    }

    private List<Throwable> getListOfCauses(Throwable ex) {
        List<Throwable> list = new ArrayList<>();
        Throwable root = ex.getCause();
        if (root == null || root == ex) {
            return list;
        }
        while (true) {
            list.add(root);
            Throwable cause2 = root.getCause();
            if (cause2 == null || cause2 == root) {
                return list;
            }
            root = root.getCause();
        }
        return list;
    }

    private Throwable getRootCause(Throwable e) {
        Throwable root = e.getCause();
        if (root == null || root == e) {
            return e;
        }
        while (true) {
            Throwable cause2 = root.getCause();
            if (cause2 == null || cause2 == root) {
                return root;
            }
            root = root.getCause();
        }
        return root;
    }
}
