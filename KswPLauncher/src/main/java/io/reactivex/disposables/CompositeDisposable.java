package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.List;

public final class CompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean disposed;
    OpenHashSet<Disposable> resources;

    public CompositeDisposable() {
    }

    public CompositeDisposable(Disposable... disposables) {
        ObjectHelper.requireNonNull(disposables, "disposables is null");
        this.resources = new OpenHashSet<>(disposables.length + 1);
        for (Disposable d : disposables) {
            ObjectHelper.requireNonNull(d, "A Disposable in the disposables array is null");
            this.resources.add(d);
        }
    }

    public CompositeDisposable(Iterable<? extends Disposable> disposables) {
        ObjectHelper.requireNonNull(disposables, "disposables is null");
        this.resources = new OpenHashSet<>();
        for (Disposable d : disposables) {
            ObjectHelper.requireNonNull(d, "A Disposable item in the disposables sequence is null");
            this.resources.add(d);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    this.disposed = true;
                    OpenHashSet<Disposable> set = this.resources;
                    this.resources = null;
                    dispose(set);
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean add(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "disposable is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    OpenHashSet<Disposable> set = this.resources;
                    if (set == null) {
                        set = new OpenHashSet<>();
                        this.resources = set;
                    }
                    set.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(Disposable... disposables) {
        ObjectHelper.requireNonNull(disposables, "disposables is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    OpenHashSet<Disposable> set = this.resources;
                    if (set == null) {
                        set = new OpenHashSet<>(disposables.length + 1);
                        this.resources = set;
                    }
                    for (Disposable d : disposables) {
                        ObjectHelper.requireNonNull(d, "A Disposable in the disposables array is null");
                        set.add(d);
                    }
                    return true;
                }
            }
        }
        for (Disposable d2 : disposables) {
            d2.dispose();
        }
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean remove(Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean delete(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "disposables is null");
        if (this.disposed) {
            return false;
        }
        synchronized (this) {
            if (this.disposed) {
                return false;
            }
            OpenHashSet<Disposable> set = this.resources;
            if (set != null) {
                if (set.remove(disposable)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void clear() {
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    OpenHashSet<Disposable> set = this.resources;
                    this.resources = null;
                    dispose(set);
                }
            }
        }
    }

    public int size() {
        int i = 0;
        if (this.disposed) {
            return 0;
        }
        synchronized (this) {
            if (this.disposed) {
                return 0;
            }
            OpenHashSet<Disposable> set = this.resources;
            if (set != null) {
                i = set.size();
            }
            return i;
        }
    }

    /* access modifiers changed from: package-private */
    public void dispose(OpenHashSet<Disposable> set) {
        if (set != null) {
            List<Throwable> errors = null;
            Object[] array = set.keys();
            for (Object o : array) {
                if (o instanceof Disposable) {
                    try {
                        ((Disposable) o).dispose();
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        if (errors == null) {
                            errors = new ArrayList<>();
                        }
                        errors.add(ex);
                    }
                }
            }
            if (errors == null) {
                return;
            }
            if (errors.size() == 1) {
                throw ExceptionHelper.wrapOrThrow(errors.get(0));
            }
            throw new CompositeException(errors);
        }
    }
}
