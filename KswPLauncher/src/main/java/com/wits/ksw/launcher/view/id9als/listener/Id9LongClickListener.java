package com.wits.ksw.launcher.view.id9als.listener;

import android.content.ClipData;
import android.content.Intent;
import android.view.View;
import com.wits.ksw.launcher.view.id9als.activity.Id9EditCardActivity;

public class Id9LongClickListener implements View.OnLongClickListener {
    private boolean isEdit;
    private View itemView;
    private final String name;

    public Id9LongClickListener(View itemView2, String name2, boolean isEdit2) {
        this.itemView = itemView2;
        this.name = name2;
        this.isEdit = isEdit2;
    }

    public boolean onLongClick(View v) {
        if (!this.isEdit) {
            this.itemView.getContext().startActivity(new Intent(this.itemView.getContext(), Id9EditCardActivity.class));
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra("name", this.name);
        ClipData.Item item = new ClipData.Item(intent);
        this.itemView.startDragAndDrop(new ClipData(this.name, new String[]{"text/plain"}, item), new View.DragShadowBuilder(this.itemView), this.name, 256);
        return false;
    }
}
