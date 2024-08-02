package com.wits.ksw.launcher.view.benzmbux2021new.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class PagingScrollHelper {
    private boolean firstTouch = true;
    ValueAnimator mAnimator = null;
    private MyOnFlingListener mOnFlingListener = new MyOnFlingListener();
    onPageChangeListener mOnPageChangeListener;
    private MyOnScrollListener mOnScrollListener = new MyOnScrollListener();
    private MyOnTouchListener mOnTouchListener = new MyOnTouchListener();
    private ORIENTATION mOrientation = ORIENTATION.HORIZONTAL;
    RecyclerView mRecyclerView = null;
    private int offsetX = 0;
    private int offsetY = 0;
    int startX = 0;
    int startY = 0;

    /* access modifiers changed from: package-private */
    public enum ORIENTATION {
        HORIZONTAL,
        VERTICAL,
        NULL
    }

    public interface onPageChangeListener {
        void onPageChange(int i);
    }

    static /* synthetic */ int access$212(PagingScrollHelper x0, int x1) {
        int i = x0.offsetY + x1;
        x0.offsetY = i;
        return i;
    }

    static /* synthetic */ int access$312(PagingScrollHelper x0, int x1) {
        int i = x0.offsetX + x1;
        x0.offsetX = i;
        return i;
    }

    public void setUpRecycleView(RecyclerView recycleView) {
        if (recycleView != null) {
            this.mRecyclerView = recycleView;
            recycleView.setOnFlingListener(this.mOnFlingListener);
            recycleView.setOnScrollListener(this.mOnScrollListener);
            recycleView.setOnTouchListener(this.mOnTouchListener);
            updateLayoutManger();
            return;
        }
        throw new IllegalArgumentException("recycleView must be not null");
    }

    public void updateLayoutManger() {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager.canScrollVertically()) {
                this.mOrientation = ORIENTATION.VERTICAL;
            } else if (layoutManager.canScrollHorizontally()) {
                this.mOrientation = ORIENTATION.HORIZONTAL;
            } else {
                this.mOrientation = ORIENTATION.NULL;
            }
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.startX = 0;
            this.startY = 0;
            this.offsetX = 0;
            this.offsetY = 0;
        }
    }

    public int getPageCount() {
        if (this.mRecyclerView == null || this.mOrientation == ORIENTATION.NULL) {
            return 0;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL && this.mRecyclerView.computeVerticalScrollExtent() != 0) {
            return this.mRecyclerView.computeVerticalScrollRange() / this.mRecyclerView.computeVerticalScrollExtent();
        }
        if (this.mRecyclerView.computeHorizontalScrollExtent() != 0) {
            Log.i("zzz", "rang=" + this.mRecyclerView.computeHorizontalScrollRange() + " extent=" + this.mRecyclerView.computeHorizontalScrollExtent());
            return this.mRecyclerView.computeHorizontalScrollRange() / this.mRecyclerView.computeHorizontalScrollExtent();
        }
        return 0;
    }

    public void scrollToPosition(int position) {
        int endPoint;
        if (this.mAnimator == null) {
            this.mOnFlingListener.onFling(0, 0);
        }
        if (this.mAnimator != null) {
            int startPoint = this.mOrientation == ORIENTATION.VERTICAL ? this.offsetY : this.offsetX;
            if (this.mOrientation == ORIENTATION.VERTICAL) {
                endPoint = this.mRecyclerView.getHeight() * position;
            } else {
                endPoint = this.mRecyclerView.getWidth() * position;
            }
            if (startPoint != endPoint) {
                this.mAnimator.setIntValues(startPoint, endPoint);
                this.mAnimator.start();
            }
        }
    }

    public void scrollToPositionNoAnimator(int position) {
        int endPoint;
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            int i = this.offsetY;
        } else {
            int i2 = this.offsetX;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            endPoint = this.mRecyclerView.getHeight() * position;
        } else {
            endPoint = this.mRecyclerView.getWidth() * position;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            this.mRecyclerView.scrollBy(0, endPoint - this.offsetY);
            return;
        }
        this.mRecyclerView.scrollBy(endPoint - this.offsetX, 0);
    }

    public class MyOnFlingListener extends RecyclerView.OnFlingListener {
        public MyOnFlingListener() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnFlingListener
        public boolean onFling(int velocityX, int velocityY) {
            int endPoint;
            int startPoint;
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.NULL) {
                return false;
            }
            int p = PagingScrollHelper.this.getStartPageIndex();
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                startPoint = PagingScrollHelper.this.offsetY;
                if (velocityY < 0) {
                    p--;
                } else if (velocityY > 0) {
                    p++;
                }
                endPoint = PagingScrollHelper.this.mRecyclerView.getHeight() * p;
            } else {
                startPoint = PagingScrollHelper.this.offsetX;
                if (velocityX < 0) {
                    p--;
                } else if (velocityX > 0) {
                    p++;
                }
                endPoint = PagingScrollHelper.this.mRecyclerView.getWidth() * p;
            }
            if (endPoint < 0) {
                endPoint = 0;
            }
            if (PagingScrollHelper.this.mAnimator == null) {
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                new ValueAnimator();
                pagingScrollHelper.mAnimator = ValueAnimator.ofInt(startPoint, endPoint);
                PagingScrollHelper.this.mAnimator.setDuration(200L);
                PagingScrollHelper.this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.wits.ksw.launcher.view.benzmbux2021new.util.PagingScrollHelper.MyOnFlingListener.AnonymousClass1 */

                    public void onAnimationUpdate(ValueAnimator animation) {
                        int nowPoint = ((Integer) animation.getAnimatedValue()).intValue();
                        if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                            PagingScrollHelper.this.mRecyclerView.scrollBy(0, nowPoint - PagingScrollHelper.this.offsetY);
                            return;
                        }
                        PagingScrollHelper.this.mRecyclerView.scrollBy(nowPoint - PagingScrollHelper.this.offsetX, 0);
                    }
                });
                PagingScrollHelper.this.mAnimator.addListener(new AnimatorListenerAdapter() {
                    /* class com.wits.ksw.launcher.view.benzmbux2021new.util.PagingScrollHelper.MyOnFlingListener.AnonymousClass2 */

                    public void onAnimationEnd(Animator animation) {
                        if (PagingScrollHelper.this.mOnPageChangeListener != null) {
                            PagingScrollHelper.this.mOnPageChangeListener.onPageChange(PagingScrollHelper.this.getPageIndex());
                        }
                        PagingScrollHelper.this.mRecyclerView.stopScroll();
                        PagingScrollHelper.this.startY = PagingScrollHelper.this.offsetY;
                        PagingScrollHelper.this.startX = PagingScrollHelper.this.offsetX;
                    }
                });
            } else {
                PagingScrollHelper.this.mAnimator.cancel();
                PagingScrollHelper.this.mAnimator.setIntValues(startPoint, endPoint);
            }
            PagingScrollHelper.this.mAnimator.start();
            return true;
        }
    }

    public class MyOnScrollListener extends RecyclerView.OnScrollListener {
        public MyOnScrollListener() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState == 0 && PagingScrollHelper.this.mOrientation != ORIENTATION.NULL) {
                int vX = 0;
                int vY = 0;
                int i = -1000;
                boolean move = true;
                if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                    if (Math.abs(PagingScrollHelper.this.offsetY - PagingScrollHelper.this.startY) <= recyclerView.getHeight() / 2) {
                        move = false;
                    }
                    vY = 0;
                    if (move) {
                        if (PagingScrollHelper.this.offsetY - PagingScrollHelper.this.startY >= 0) {
                            i = 1000;
                        }
                        vY = i;
                    }
                } else {
                    if (Math.abs(PagingScrollHelper.this.offsetX - PagingScrollHelper.this.startX) <= recyclerView.getWidth() / 2) {
                        move = false;
                    }
                    if (move) {
                        if (PagingScrollHelper.this.offsetX - PagingScrollHelper.this.startX >= 0) {
                            i = 1000;
                        }
                        vX = i;
                    }
                }
                PagingScrollHelper.this.mOnFlingListener.onFling(vX, vY);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            PagingScrollHelper.access$212(PagingScrollHelper.this, dy);
            PagingScrollHelper.access$312(PagingScrollHelper.this, dx);
        }
    }

    public class MyOnTouchListener implements View.OnTouchListener {
        public MyOnTouchListener() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (PagingScrollHelper.this.firstTouch) {
                PagingScrollHelper.this.firstTouch = false;
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                pagingScrollHelper.startY = pagingScrollHelper.offsetY;
                PagingScrollHelper pagingScrollHelper2 = PagingScrollHelper.this;
                pagingScrollHelper2.startX = pagingScrollHelper2.offsetX;
            }
            if (event.getAction() == 1 || event.getAction() == 3) {
                PagingScrollHelper.this.firstTouch = true;
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getPageIndex() {
        if (this.mRecyclerView.getHeight() == 0 || this.mRecyclerView.getWidth() == 0) {
            return 0;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            return this.offsetY / this.mRecyclerView.getHeight();
        }
        return this.offsetX / this.mRecyclerView.getWidth();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getStartPageIndex() {
        if (this.mRecyclerView.getHeight() == 0 || this.mRecyclerView.getWidth() == 0) {
            return 0;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            return this.startY / this.mRecyclerView.getHeight();
        }
        return this.startX / this.mRecyclerView.getWidth();
    }

    public void setOnPageChangeListener(onPageChangeListener listener) {
        this.mOnPageChangeListener = listener;
    }
}
