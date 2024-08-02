package com.wits.ksw.launcher.view.id8ug;

import java.util.Iterator;

/* renamed from: com.wits.ksw.launcher.view.id8ug.Id8UgEditActivity-$$ExternalSynthetic0 */
public /* synthetic */ class Id8UgEditActivity$$ExternalSynthetic0 {
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
