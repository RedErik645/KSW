package kotlin.reflect;

import com.ibm.icu.text.PluralRules;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", PluralRules.KEYWORD_OTHER, "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TypesJVM.kt */
public final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    private final Type ownerType;
    private final Class<?> rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class<?> cls, Type ownerType2, List<? extends Type> $this$toTypedArray$iv) {
        Intrinsics.checkNotNullParameter(cls, "rawType");
        Intrinsics.checkNotNullParameter($this$toTypedArray$iv, "typeArguments");
        this.rawType = cls;
        this.ownerType = ownerType2;
        Object[] array = $this$toTypedArray$iv.toArray(new Type[0]);
        if (array != null) {
            this.typeArguments = (Type[]) array;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public Type getRawType() {
        return this.rawType;
    }

    public Type getOwnerType() {
        return this.ownerType;
    }

    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override // kotlin.reflect.TypeImpl
    public String getTypeName() {
        StringBuilder $this$getTypeName_u24lambda_u2d0 = new StringBuilder();
        Type type = this.ownerType;
        if (type != null) {
            $this$getTypeName_u24lambda_u2d0.append(TypesJVMKt.typeToString(type));
            $this$getTypeName_u24lambda_u2d0.append("$");
            $this$getTypeName_u24lambda_u2d0.append(this.rawType.getSimpleName());
        } else {
            $this$getTypeName_u24lambda_u2d0.append(TypesJVMKt.typeToString(this.rawType));
        }
        Type[] typeArr = this.typeArguments;
        if (!(typeArr.length == 0)) {
            ArraysKt.joinTo$default(typeArr, $this$getTypeName_u24lambda_u2d0, (CharSequence) null, "<", ">", 0, (CharSequence) null, ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, (Object) null);
        }
        String sb = $this$getTypeName_u24lambda_u2d0.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    public boolean equals(Object other) {
        return (other instanceof ParameterizedType) && Intrinsics.areEqual(this.rawType, ((ParameterizedType) other).getRawType()) && Intrinsics.areEqual(this.ownerType, ((ParameterizedType) other).getOwnerType()) && Arrays.equals(getActualTypeArguments(), ((ParameterizedType) other).getActualTypeArguments());
    }

    public int hashCode() {
        int hashCode = this.rawType.hashCode();
        Type type = this.ownerType;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
