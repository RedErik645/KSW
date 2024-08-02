package com.wits.ksw.launcher.view.id8ug.listener;

import android.content.ClipData;
import android.content.Intent;
import android.view.View;

public class Id8UgLongClickListener implements View.OnLongClickListener {
    private View itemView;
    private final String name;

    public Id8UgLongClickListener(View itemView2, String name2) {
        this.itemView = itemView2;
        this.name = name2;
    }

    public boolean onLongClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", this.name);
        ClipData.Item item = new ClipData.Item(intent);
        this.itemView.startDragAndDrop(new ClipData(this.name, new String[]{"text/plain"}, item), new View.DragShadowBuilder(this.itemView), null, 256);
        return true;
    }
}
