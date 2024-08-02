package com.wits.ksw.launcher.view.id9als;

import java.util.Iterator;

/* renamed from: com.wits.ksw.launcher.view.id9als.Id9AlsViewManager-$$ExternalSynthetic0 */
public /* synthetic */ class Id9AlsViewManager$$ExternalSynthetic0 {
    public static /* synthetic */ String m0(CharSequence charSequence, Iterable iterable) {
        if (charSequence != null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = iterable.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(charSequence);
                }
            }
            return sb.toString();
        }
        throw new NullPointerException("delimiter");
    }
}
