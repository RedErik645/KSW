package android.databinding;

import android.view.View;
import android.view.ViewStub;

public class ViewStubProxy {
    private ViewDataBinding mContainingBinding;
    private ViewStub.OnInflateListener mOnInflateListener;
    private ViewStub.OnInflateListener mProxyListener;
    private View mRoot;
    private ViewDataBinding mViewDataBinding;
    private ViewStub mViewStub;

    public ViewStubProxy(ViewStub viewStub) {
        AnonymousClass1 r0 = new ViewStub.OnInflateListener() {
            /* class android.databinding.ViewStubProxy.AnonymousClass1 */

            public void onInflate(ViewStub stub, View inflated) {
                ViewStubProxy.this.mRoot = inflated;
                ViewStubProxy viewStubProxy = ViewStubProxy.this;
                viewStubProxy.mViewDataBinding = DataBindingUtil.bind(viewStubProxy.mContainingBinding.mBindingComponent, inflated, stub.getLayoutResource());
                ViewStubProxy.this.mViewStub = null;
                if (ViewStubProxy.this.mOnInflateListener != null) {
                    ViewStubProxy.this.mOnInflateListener.onInflate(stub, inflated);
                    ViewStubProxy.this.mOnInflateListener = null;
                }
                ViewStubProxy.this.mContainingBinding.invalidateAll();
                ViewStubProxy.this.mContainingBinding.forceExecuteBindings();
            }
        };
        this.mProxyListener = r0;
        this.mViewStub = viewStub;
        viewStub.setOnInflateListener(r0);
    }

    public void setContainingBinding(ViewDataBinding containingBinding) {
        this.mContainingBinding = containingBinding;
    }

    public boolean isInflated() {
        return this.mRoot != null;
    }

    public View getRoot() {
        return this.mRoot;
    }

    public ViewDataBinding getBinding() {
        return this.mViewDataBinding;
    }

    public ViewStub getViewStub() {
        return this.mViewStub;
    }

    public void setOnInflateListener(ViewStub.OnInflateListener listener) {
        if (this.mViewStub != null) {
            this.mOnInflateListener = listener;
        }
    }
}
