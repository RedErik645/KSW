package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int arity;
    private final int flags;

    public FunctionReference(int arity2) {
        this(arity2, NO_RECEIVER, null, null, null, 0);
    }

    public FunctionReference(int arity2, Object receiver) {
        this(arity2, receiver, null, null, null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionReference(int arity2, Object receiver, Class owner, String name, String signature, int flags2) {
        super(receiver, owner, name, signature, (flags2 & 1) != 1 ? false : true);
        this.arity = arity2;
        this.flags = flags2 >> 1;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.function(this);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KFunction, kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference other = (FunctionReference) obj;
            if (!getName().equals(other.getName()) || !getSignature().equals(other.getSignature()) || this.flags != other.flags || this.arity != other.arity || !Intrinsics.areEqual(getBoundReceiver(), other.getBoundReceiver()) || !Intrinsics.areEqual(getOwner(), other.getOwner())) {
                return false;
            }
            return true;
        } else if (obj instanceof KFunction) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        KCallable reflected = compute();
        if (reflected != this) {
            return reflected.toString();
        }
        return "<init>".equals(getName()) ? "constructor (Kotlin reflection is not available)" : "function " + getName() + " (Kotlin reflection is not available)";
    }
}
