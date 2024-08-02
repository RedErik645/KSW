package skin.support.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import skin.support.widget.SkinCompatCardView;

public class SkinCardViewInflater implements SkinLayoutInflater {
    @Override // skin.support.app.SkinLayoutInflater
    public View createView(Context context, String name, AttributeSet attrs) {
        char c;
        switch (name.hashCode()) {
            case 1677098064:
                if (name.equals("android.support.v7.widget.CardView")) {
                    c = 0;
                    break;
                }
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return new SkinCompatCardView(context, attrs);
            default:
                return null;
        }
    }
}