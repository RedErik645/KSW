package kotlin.text;

import com.wits.ksw.launcher.view.benzgs.BenzConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "R", BenzConfig.INDEX, "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: _Strings.kt */
final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements Function1<Integer, R> {
    final /* synthetic */ int $size;
    final /* synthetic */ CharSequence $this_windowedSequence;
    final /* synthetic */ Function1<CharSequence, R> $transform;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.CharSequence, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt___StringsKt$windowedSequence$2(int i, CharSequence charSequence, Function1<? super CharSequence, ? extends R> function1) {
        super(1);
        this.$size = i;
        this.$this_windowedSequence = charSequence;
        this.$transform = function1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final R invoke(int index) {
        int end = this.$size + index;
        return this.$transform.invoke(this.$this_windowedSequence.subSequence(index, (end < 0 || end > this.$this_windowedSequence.length()) ? this.$this_windowedSequence.length() : end));
    }
}