package com.wits.ksw.launcher.view.lexusls.drag;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.launcher.bean.lexusls.LexusLsAppSelBean;

public class DraggableLayout extends LinearLayout implements DropTarget, DragSource {
    private static final int ANIMATION_DURATION = 600;
    private Animation alphaAnima = new AlphaAnimation(0.38f, 0.08f);
    private int cellNumber;
    private LexusLsAppSelBean gridItem;
    private ImageView image;
    private boolean isDelete;
    private LinearLayout layoutLL;
    private DragListener listener;
    private TextView text;

    public DraggableLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DraggableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DraggableLayout(Context context) {
        super(context);
    }

    @Override // com.wits.ksw.launcher.view.lexusls.drag.DropTarget
    public void onDrop(DragSource source, int x, int y, int xOffset, int yOffset, DragView dragView, Object dragInfo) {
    }

    @Override // com.wits.ksw.launcher.view.lexusls.drag.DropTarget
    public void onDragEnter(DragSource source, int x, int y, int xOffset, int yOffset, DragView dragView, Object dragInfo) {
        mDragEnterAnimation(true);
    }

    @Override // com.wits.ksw.launcher.view.lexusls.drag.DropTarget
    public void onDragOver(DragSource source, int x, int y, int xOffset, int yOffset, DragView dragView, Object dragInfo) {
    }

    @Override // com.wits.ksw.launcher.view.lexusls.drag.DropTarget
    public void onDragExit(DragSource source, int x, int y, int xOffset, int yOffset, DragView dragView, Object dragInfo) {
        mDragEnterAnimation(false);
    }

    @Override // com.wits.ksw.launcher.view.lexusls.drag.DropTarget
    public boolean acceptDrop(DragSource source, int x, int y, int xOffset, int yOffset, DragView dragView, Object dragInfo) {
        return source != this;
    }

    @Override // com.wits.ksw.launcher.view.lexusls.drag.DropTarget
    public Rect estimateDropLocation(DragSource source, int x, int y, int xOffset, int yOffset, DragView dragView, Object dragInfo, Rect recycle) {
        return null;
    }

    @Override // com.wits.ksw.launcher.view.lexusls.drag.DragSource
    public void setDragController(DragController dragger) {
    }

    @Override // com.wits.ksw.launcher.view.lexusls.drag.DragSource
    public void onDropCompleted(View target, boolean success) {
        DragListener dragListener = this.listener;
        if (dragListener != null) {
            dragListener.onDropCompleted(this, target, success);
        }
    }

    public void setImage(ImageView image2) {
        this.image = image2;
    }

    public ImageView getImage() {
        return this.image;
    }

    public void setText(TextView text2) {
        this.text = text2;
    }

    public TextView getText() {
        return this.text;
    }

    public void setItem(LexusLsAppSelBean gridItem2) {
        this.gridItem = gridItem2;
    }

    public LexusLsAppSelBean getItem() {
        return this.gridItem;
    }

    public void setDragListener(DragListener listener2) {
        this.listener = listener2;
    }

    public void setAnimaView(LinearLayout layoutLL2) {
        this.layoutLL = layoutLL2;
    }

    @Override // com.wits.ksw.launcher.view.lexusls.drag.DragSource
    public boolean isDelete() {
        return this.isDelete;
    }

    public void canDelete(boolean b) {
        this.isDelete = b;
    }

    public void mDragEnterAnimation(final boolean isNeedAnima) {
        if (this.layoutLL != null) {
            this.alphaAnima.setDuration(600);
            this.alphaAnima.setAnimationListener(new Animation.AnimationListener() {
                /* class com.wits.ksw.launcher.view.lexusls.drag.DraggableLayout.AnonymousClass1 */

                public void onAnimationEnd(Animation animation) {
                    if (isNeedAnima) {
                        DraggableLayout.this.alphaAnima.reset();
                        DraggableLayout.this.layoutLL.startAnimation(DraggableLayout.this.alphaAnima);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            this.layoutLL.startAnimation(this.alphaAnima);
        }
    }
}
