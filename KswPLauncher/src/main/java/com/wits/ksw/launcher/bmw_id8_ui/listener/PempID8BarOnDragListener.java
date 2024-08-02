package com.wits.ksw.launcher.bmw_id8_ui.listener;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bmw_id8_ui.PempID8LauncherConstants;

public class PempID8BarOnDragListener implements View.OnDragListener {
    private static final String TAG = "CardOnDragListener";
    private final Context context;

    public PempID8BarOnDragListener(Context context2) {
        this.context = context2;
    }

    public boolean onDrag(View v, DragEvent event) {
        int iconRes;
        switch (event.getAction()) {
            case 3:
                Log.w(TAG, "onDrag: 导航栏的");
                int id = v.getId();
                if (id == R.id.ll_left_1 || id == R.id.ll_left_2) {
                    Toast.makeText(this.context, "这个不允许更换", 0).show();
                    return true;
                }
                Log.w(TAG, "onDrag id : " + id);
                Intent intent = event.getClipData().getItemAt(0).getIntent();
                String name = intent.getStringExtra("name");
                int nameRes = intent.getIntExtra("nameRes", -1);
                if (nameRes != -1 && (iconRes = intent.getIntExtra("iconRes", -1)) != -1 && PempID8LauncherConstants.changeLeftIcon(id, name)) {
                    Bitmap bitmap = BitmapFactory.decodeResource(this.context.getResources(), iconRes);
                    ImageView imageView = null;
                    TextView textView = null;
                    switch (id) {
                        case R.id.ll_left_3 /*{ENCODED_INT: 2131231956}*/:
                            imageView = (ImageView) v.findViewById(R.id.iv_left_3);
                            textView = (TextView) v.findViewById(R.id.tv_left_3);
                            break;
                        case R.id.ll_left_4 /*{ENCODED_INT: 2131231957}*/:
                            imageView = (ImageView) v.findViewById(R.id.iv_left_4);
                            textView = (TextView) v.findViewById(R.id.tv_left_4);
                            break;
                        case R.id.ll_left_5 /*{ENCODED_INT: 2131231958}*/:
                            imageView = (ImageView) v.findViewById(R.id.iv_left_5);
                            textView = (TextView) v.findViewById(R.id.tv_left_5);
                            break;
                    }
                    if (imageView != null) {
                        imageView.setImageBitmap(bitmap);
                        textView.setText(this.context.getString(nameRes));
                        break;
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
                break;
        }
        return true;
    }
}
