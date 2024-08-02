package android.databinding.adapters;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ListenerUtil {
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> sListeners = new SparseArray<>();

    public static <T> T trackListener(View view, T listener, int listenerResourceId) {
        WeakReference<?> weakReference;
        if (Build.VERSION.SDK_INT >= 14) {
            T oldValue = (T) view.getTag(listenerResourceId);
            view.setTag(listenerResourceId, listener);
            return oldValue;
        }
        SparseArray<WeakHashMap<View, WeakReference<?>>> sparseArray = sListeners;
        synchronized (sparseArray) {
            WeakHashMap<View, WeakReference<?>> listeners = sparseArray.get(listenerResourceId);
            if (listeners == null) {
                listeners = new WeakHashMap<>();
                sparseArray.put(listenerResourceId, listeners);
            }
            if (listener == null) {
                weakReference = listeners.remove(view);
            } else {
                weakReference = listeners.put(view, new WeakReference<>(listener));
            }
            if (weakReference == null) {
                return null;
            }
            return (T) weakReference.get();
        }
    }

    public static <T> T getListener(View view, int listenerResourceId) {
        if (Build.VERSION.SDK_INT >= 14) {
            return (T) view.getTag(listenerResourceId);
        }
        SparseArray<WeakHashMap<View, WeakReference<?>>> sparseArray = sListeners;
        synchronized (sparseArray) {
            WeakHashMap<View, WeakReference<?>> listeners = sparseArray.get(listenerResourceId);
            if (listeners == null) {
                return null;
            }
            WeakReference<?> weakReference = listeners.get(view);
            if (weakReference == null) {
                return null;
            }
            return (T) weakReference.get();
        }
    }
}
