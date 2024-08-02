package kotlin.text;

import com.wits.ksw.launcher.view.benzgs.BenzConfig;
import kotlin.Metadata;
import kotlin.collections.AbstractList;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", BenzConfig.INDEX, "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Regex.kt */
public final class MatcherMatchResult$groupValues$1 extends AbstractList<String> {
    final /* synthetic */ MatcherMatchResult this$0;

    MatcherMatchResult$groupValues$1(MatcherMatchResult $receiver) {
        this.this$0 = $receiver;
    }

    @Override // kotlin.collections.AbstractCollection
    public final /* bridge */ boolean contains(Object element) {
        if (!(element instanceof String)) {
            return false;
        }
        return contains((String) element);
    }

    public /* bridge */ boolean contains(String element) {
        return super.contains((Object) element);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.collections.AbstractList
    public final /* bridge */ int indexOf(String str) {
        if (!(str instanceof String)) {
            return -1;
        }
        return indexOf(str);
    }

    public /* bridge */ int indexOf(String element) {
        return super.indexOf((Object) element);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.collections.AbstractList
    public final /* bridge */ int lastIndexOf(String str) {
        if (!(str instanceof String)) {
            return -1;
        }
        return lastIndexOf(str);
    }

    public /* bridge */ int lastIndexOf(String element) {
        return super.lastIndexOf((Object) element);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return MatcherMatchResult.access$getMatchResult(this.this$0).groupCount() + 1;
    }

    @Override // java.util.List, kotlin.collections.AbstractList
    public String get(int index) {
        String group = MatcherMatchResult.access$getMatchResult(this.this$0).group(index);
        return group == null ? "" : group;
    }
}
