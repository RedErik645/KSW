package com.bumptech.glide.manager;

/* access modifiers changed from: package-private */
public class ApplicationLifecycle implements Lifecycle {
    ApplicationLifecycle() {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener listener) {
        listener.onStart();
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener listener) {
    }
}
