package com.wits.ksw.launcher.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LoopRotarySwitchView extends RelativeLayout {
    private static final int LoopR = 200;
    private static final String TAG = "LoopRotarySwitchView";
    private static final int horizontal = 1;
    private static Boolean isCanSwitchItem = true;
    private static final int vertical = 0;
    private float angle;
    private AutoScrollDirection autoRotatinDirection;
    private boolean autoRotation;
    int bottom;
    private float distance;
    Handler handlerFocus;
    private boolean isCanClickListener;
    private float last_angle;
    private float limitX;
    LoopRotarySwitchViewHandler loopHandler;
    private int loopRotationX;
    private int loopRotationZ;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private int mOrientation;
    private float multiple;
    private OnItemClickListener onItemClickListener;
    private OnItemSelectedListener onItemSelectedListener;
    private OnLoopViewTouchListener onLoopViewTouchListener;
    private float r;
    private ValueAnimator rAnimation;
    private ValueAnimator restAnimator;
    private int selectItem;
    private int size;
    private boolean touching;
    private View viewPreFocus;
    private List<View> views;
    private float x;
    private ValueAnimator xAnimation;
    private ValueAnimator zAnimation;

    public enum AutoScrollDirection {
        left,
        right
    }

    public interface OnItemClickListener {
        void onItemClick(int i, View view);
    }

    public interface OnItemSelectedListener {
        void selected(int i, View view);
    }

    public interface OnLoopViewTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    static /* synthetic */ float access$218(LoopRotarySwitchView x0, double x1) {
        float f = (float) (((double) x0.angle) + x1);
        x0.angle = f;
        return f;
    }

    public LoopRotarySwitchView(Context context) {
        this(context, null);
    }

    public LoopRotarySwitchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoopRotarySwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mOrientation = 1;
        this.restAnimator = null;
        this.rAnimation = null;
        this.zAnimation = null;
        this.xAnimation = null;
        this.loopRotationX = 0;
        this.loopRotationZ = 0;
        this.mGestureDetector = null;
        this.selectItem = 0;
        this.size = 0;
        this.r = 200.0f;
        this.multiple = 2.0f;
        this.distance = 2.0f * 200.0f;
        this.angle = 0.0f;
        this.last_angle = 0.0f;
        this.autoRotation = false;
        this.touching = false;
        this.autoRotatinDirection = AutoScrollDirection.left;
        this.views = new ArrayList();
        this.onItemSelectedListener = null;
        this.onLoopViewTouchListener = null;
        this.onItemClickListener = null;
        this.isCanClickListener = true;
        this.limitX = 30.0f;
        this.viewPreFocus = null;
        this.loopHandler = new LoopRotarySwitchViewHandler(3000) {
            /* class com.wits.ksw.launcher.view.LoopRotarySwitchView.AnonymousClass1 */

            @Override // com.wits.ksw.launcher.view.LoopRotarySwitchViewHandler
            public void doScroll() {
                try {
                    if (LoopRotarySwitchView.this.size != 0) {
                        int perAngle = 0;
                        switch (AnonymousClass11.$SwitchMap$com$wits$ksw$launcher$view$LoopRotarySwitchView$AutoScrollDirection[LoopRotarySwitchView.this.autoRotatinDirection.ordinal()]) {
                            case 1:
                                perAngle = Constants.DEFAULT_SWEEP_ANGLE / LoopRotarySwitchView.this.size;
                                break;
                            case 2:
                                perAngle = -360 / LoopRotarySwitchView.this.size;
                                break;
                        }
                        if (LoopRotarySwitchView.this.angle == 360.0f) {
                            LoopRotarySwitchView.this.angle = 0.0f;
                        }
                        LoopRotarySwitchView loopRotarySwitchView = LoopRotarySwitchView.this;
                        loopRotarySwitchView.AnimRotationTo(loopRotarySwitchView.angle + ((float) perAngle), null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.handlerFocus = new Handler(new Handler.Callback() {
            /* class com.wits.ksw.launcher.view.$$Lambda$LoopRotarySwitchView$5rHmlGhZkb5CATTmKmVRrCSyfg */

            public final boolean handleMessage(Message message) {
                return LoopRotarySwitchView.this.lambda$new$0$LoopRotarySwitchView(message);
            }
        });
        this.bottom = 0;
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoopRotarySwitchView);
        this.mOrientation = typedArray.getInt(2, 1);
        this.autoRotation = typedArray.getBoolean(0, false);
        this.r = typedArray.getDimension(3, 200.0f);
        int direction = typedArray.getInt(1, 0);
        typedArray.recycle();
        this.mGestureDetector = new GestureDetector(context, getGeomeryController());
        if (this.mOrientation == 1) {
            this.loopRotationZ = 0;
        } else {
            this.loopRotationZ = 90;
        }
        if (direction == 0) {
            this.autoRotatinDirection = AutoScrollDirection.left;
        } else {
            this.autoRotatinDirection = AutoScrollDirection.right;
        }
        this.loopHandler.setLoop(this.autoRotation);
    }

    /* renamed from: com.wits.ksw.launcher.view.LoopRotarySwitchView$11  reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$wits$ksw$launcher$view$LoopRotarySwitchView$AutoScrollDirection;

        static {
            int[] iArr = new int[AutoScrollDirection.values().length];
            $SwitchMap$com$wits$ksw$launcher$view$LoopRotarySwitchView$AutoScrollDirection = iArr;
            try {
                iArr[AutoScrollDirection.left.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$wits$ksw$launcher$view$LoopRotarySwitchView$AutoScrollDirection[AutoScrollDirection.right.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.wits.ksw.settings.ntg6.one_layout.Ntg6VocModeLayout */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> void sortList(List<View> list) {
        Comparator comparator = new SortComparator();
        Object[] array = list.toArray(new Object[list.size()]);
        Arrays.sort(array, comparator);
        int i = 0;
        ListIterator<View> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(array[i]);
            i++;
        }
        for (int j = 0; j < list.size(); j++) {
            list.get(j).bringToFront();
        }
    }

    /* access modifiers changed from: private */
    public class SortComparator implements Comparator<View> {
        private SortComparator() {
        }

        public int compare(View lhs, View rhs) {
            try {
                return (int) ((lhs.getScaleX() * 1000.0f) - (rhs.getScaleX() * 1000.0f));
            } catch (Exception e) {
                return 0;
            }
        }
    }

    private GestureDetector.SimpleOnGestureListener getGeomeryController() {
        return new GestureDetector.SimpleOnGestureListener() {
            /* class com.wits.ksw.launcher.view.LoopRotarySwitchView.AnonymousClass2 */

            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                LoopRotarySwitchView loopRotarySwitchView = LoopRotarySwitchView.this;
                LoopRotarySwitchView.access$218(loopRotarySwitchView, (Math.cos(Math.toRadians((double) loopRotarySwitchView.loopRotationZ)) * ((double) (distanceX / 4.0f))) + (Math.sin(Math.toRadians((double) LoopRotarySwitchView.this.loopRotationZ)) * ((double) (distanceY / 4.0f))));
                LoopRotarySwitchView.this.initView();
                return true;
            }
        };
    }

    public /* synthetic */ boolean lambda$new$0$LoopRotarySwitchView(Message message) {
        switch (message.what) {
            case 0:
                Log.i(TAG, "handler i=" + message.arg1);
                setSelectItem(message.arg1);
                return false;
            default:
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0194 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 446
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.launcher.view.LoopRotarySwitchView.initView():void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initView();
        if (this.autoRotation) {
            LoopRotarySwitchViewHandler loopRotarySwitchViewHandler = this.loopHandler;
            loopRotarySwitchViewHandler.sendEmptyMessageDelayed(1000, loopRotarySwitchViewHandler.loopTime);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r2, int b) {
        super.onLayout(changed, l, t, r2, b);
        if (changed) {
            checkChildView();
            OnItemSelectedListener onItemSelectedListener2 = this.onItemSelectedListener;
            if (onItemSelectedListener2 != null) {
                this.isCanClickListener = true;
                int i = this.selectItem;
                onItemSelectedListener2.selected(i, this.views.get(i));
            }
            RAnimation();
        }
    }

    public void RAnimation() {
        RAnimation(1.0f, this.r);
    }

    public void RAnimation(boolean fromZeroToLoopR) {
        if (fromZeroToLoopR) {
            RAnimation(1.0f, 200.0f);
        } else {
            RAnimation(200.0f, 1.0f);
        }
    }

    public void RAnimation(float from, float to) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(from, to);
        this.rAnimation = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.wits.ksw.launcher.view.LoopRotarySwitchView.AnonymousClass4 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoopRotarySwitchView.this.r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LoopRotarySwitchView.this.initView();
            }
        });
        this.rAnimation.setInterpolator(new DecelerateInterpolator());
        this.rAnimation.setDuration(0L);
        this.rAnimation.start();
    }

    public void checkChildView() {
        for (int i = 0; i < this.views.size(); i++) {
            this.views.remove(i);
        }
        int count = getChildCount();
        this.size = count;
        for (final int i2 = 0; i2 < count; i2++) {
            View view = getChildAt(i2);
            this.views.add(view);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.LoopRotarySwitchView.AnonymousClass5 */

                public void onClick(View v) {
                    Log.i(LoopRotarySwitchView.TAG, "onClick: isCanClickListener=" + LoopRotarySwitchView.this.isCanClickListener + " v=" + v);
                    if (i2 != LoopRotarySwitchView.this.selectItem && LoopRotarySwitchView.isCanSwitchItem.booleanValue()) {
                        LoopRotarySwitchView.this.setSelectItem(i2);
                    }
                    if (LoopRotarySwitchView.this.isCanClickListener && LoopRotarySwitchView.this.onItemClickListener != null) {
                        LoopRotarySwitchView.this.onItemClickListener.onItemClick(i2, (View) LoopRotarySwitchView.this.views.get(i2));
                    }
                }
            });
        }
        setFocusView();
    }

    private void restPosition() {
        float finall;
        int i = this.size;
        if (i != 0) {
            float part = (float) (Constants.DEFAULT_SWEEP_ANGLE / i);
            float f = this.angle;
            if (f < 0.0f) {
                part = -part;
            }
            float minvalue = ((float) ((int) (f / part))) * part;
            float maxvalue = (((float) ((int) (f / part))) * part) + part;
            if (f >= 0.0f) {
                if (f - this.last_angle > 0.0f) {
                    finall = maxvalue;
                } else {
                    finall = minvalue;
                }
            } else if (f - this.last_angle < 0.0f) {
                finall = maxvalue;
            } else {
                finall = minvalue;
            }
            AnimRotationTo(finall, null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void AnimRotationTo(float finall, final Runnable complete) {
        float f = this.angle;
        if (f != finall) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, finall);
            this.restAnimator = ofFloat;
            ofFloat.setInterpolator(new DecelerateInterpolator());
            this.restAnimator.setDuration(300L);
            this.restAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.wits.ksw.launcher.view.LoopRotarySwitchView.AnonymousClass6 */

                public void onAnimationUpdate(ValueAnimator animation) {
                    if (!LoopRotarySwitchView.this.touching) {
                        LoopRotarySwitchView.this.angle = ((Float) animation.getAnimatedValue()).floatValue();
                        LoopRotarySwitchView.this.initView();
                    }
                }
            });
            this.restAnimator.addListener(new Animator.AnimatorListener() {
                /* class com.wits.ksw.launcher.view.LoopRotarySwitchView.AnonymousClass7 */

                public void onAnimationStart(Animator animation) {
                    Log.d(LoopRotarySwitchView.TAG, "onAnimationStart: ");
                    Boolean unused = LoopRotarySwitchView.isCanSwitchItem = false;
                }

                public void onAnimationEnd(Animator animation) {
                    Log.d(LoopRotarySwitchView.TAG, "onAnimationEnd: ");
                    Boolean unused = LoopRotarySwitchView.isCanSwitchItem = true;
                    if (!LoopRotarySwitchView.this.touching) {
                        LoopRotarySwitchView loopRotarySwitchView = LoopRotarySwitchView.this;
                        loopRotarySwitchView.selectItem = loopRotarySwitchView.calculateItem();
                        Log.i(LoopRotarySwitchView.TAG, "onAnimationEnd: selectitem=" + LoopRotarySwitchView.this.selectItem);
                        if (LoopRotarySwitchView.this.selectItem < 0) {
                            LoopRotarySwitchView loopRotarySwitchView2 = LoopRotarySwitchView.this;
                            loopRotarySwitchView2.selectItem = loopRotarySwitchView2.size + LoopRotarySwitchView.this.selectItem;
                        }
                        if (LoopRotarySwitchView.this.onItemSelectedListener != null) {
                            LoopRotarySwitchView.this.onItemSelectedListener.selected(LoopRotarySwitchView.this.selectItem, (View) LoopRotarySwitchView.this.views.get(LoopRotarySwitchView.this.selectItem));
                        }
                        LoopRotarySwitchView.this.setFocusView();
                        LoopRotarySwitchView.this.isCanClickListener = true;
                    }
                }

                public void onAnimationCancel(Animator animation) {
                }

                public void onAnimationRepeat(Animator animation) {
                }
            });
            if (complete != null) {
                this.restAnimator.addListener(new Animator.AnimatorListener() {
                    /* class com.wits.ksw.launcher.view.LoopRotarySwitchView.AnonymousClass8 */

                    public void onAnimationStart(Animator animation) {
                    }

                    public void onAnimationEnd(Animator animation) {
                        complete.run();
                    }

                    public void onAnimationCancel(Animator animation) {
                    }

                    public void onAnimationRepeat(Animator animation) {
                    }
                });
            }
            this.restAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setFocusView() {
        Iterator<View> it = this.views.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            View view = it.next();
            if (this.views.get(this.selectItem).getId() == view.getId()) {
                z = true;
            }
            view.setSelected(z);
        }
        if (!this.views.get(this.selectItem).hasFocus()) {
            this.views.get(this.selectItem).setFocusable(true);
            this.views.get(this.selectItem).setFocusableInTouchMode(true);
            this.views.get(this.selectItem).requestFocus();
            this.views.get(this.selectItem).setFocusableInTouchMode(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int calculateItem() {
        float f = this.angle % 360.0f;
        this.angle = f;
        int i = this.size;
        return ((int) (f / ((float) (Constants.DEFAULT_SWEEP_ANGLE / i)))) % i;
    }

    private boolean onTouch(MotionEvent event) {
        if (event.getAction() == 0) {
            this.last_angle = this.angle;
            this.touching = true;
        }
        if (this.mGestureDetector.onTouchEvent(event)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (event.getAction() != 1 && event.getAction() != 3) {
            return true;
        }
        this.touching = false;
        restPosition();
        return true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        OnLoopViewTouchListener onLoopViewTouchListener2 = this.onLoopViewTouchListener;
        if (onLoopViewTouchListener2 != null) {
            onLoopViewTouchListener2.onTouch(event);
        }
        isCanClickListener(event);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        onTouch(ev);
        OnLoopViewTouchListener onLoopViewTouchListener2 = this.onLoopViewTouchListener;
        if (onLoopViewTouchListener2 != null) {
            onLoopViewTouchListener2.onTouch(ev);
        }
        isCanClickListener(ev);
        return super.dispatchTouchEvent(ev);
    }

    public void isCanClickListener(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                this.x = event.getX();
                if (this.autoRotation) {
                    this.loopHandler.removeMessages(1000);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.autoRotation) {
                    LoopRotarySwitchViewHandler loopRotarySwitchViewHandler = this.loopHandler;
                    loopRotarySwitchViewHandler.sendEmptyMessageDelayed(1000, loopRotarySwitchViewHandler.loopTime);
                }
                float x2 = event.getX();
                float f = this.x;
                if (x2 - f > this.limitX || f - event.getX() > this.limitX) {
                    this.isCanClickListener = false;
                    return;
                } else {
                    this.isCanClickListener = true;
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    public List<View> getViews() {
        return this.views;
    }

    public float getAngle() {
        return this.angle;
    }

    public void setAngle(float angle2) {
        this.angle = angle2;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float distance2) {
        this.distance = distance2;
    }

    public float getR() {
        return this.r;
    }

    public int getSelectItem() {
        return this.selectItem;
    }

    public void setSelectItem(int pos) {
        Log.i(TAG, "setSelectItem: pos=" + pos);
        ValueAnimator valueAnimator = this.restAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.restAnimator.end();
            this.restAnimator.cancel();
        }
        if (pos >= 0 && pos < this.views.size()) {
            int calculateItem = calculateItem();
            this.bottom = calculateItem;
            if (calculateItem == pos) {
                Log.e("setToPos", "bottom");
            }
            int difPos = this.bottom - pos;
            if (((double) difPos) < 0.0d - Math.floor((double) (this.views.size() / 2))) {
                difPos += this.views.size();
            }
            if (((double) difPos) > Math.floor((double) (this.views.size() / 2))) {
                difPos -= this.views.size();
            }
            if (this.views.size() % 2 == 0 && difPos == this.views.size() / 2) {
                difPos = (this.views.size() / 2) + 0;
            }
            float angle1 = this.angle - ((((float) difPos) * 360.0f) / ((float) this.views.size()));
            Log.i(TAG, "setSelectItem: difPos=" + difPos + " angle1=" + angle1);
            AnimRotationTo(angle1, null);
        }
    }

    public LoopRotarySwitchView setR(float r2) {
        this.r = r2;
        this.distance = this.multiple * r2;
        return this;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener2) {
        this.onItemSelectedListener = onItemSelectedListener2;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void setOnLoopViewTouchListener(OnLoopViewTouchListener onLoopViewTouchListener2) {
        this.onLoopViewTouchListener = onLoopViewTouchListener2;
    }

    public LoopRotarySwitchView setAutoRotation(boolean autoRotation2) {
        this.autoRotation = autoRotation2;
        this.loopHandler.setLoop(autoRotation2);
        return this;
    }

    public long getAutoRotationTime() {
        return this.loopHandler.loopTime;
    }

    public LoopRotarySwitchView setAutoRotationTime(long autoRotationTime) {
        this.loopHandler.setLoopTime(autoRotationTime);
        return this;
    }

    public boolean isAutoRotation() {
        return this.autoRotation;
    }

    public LoopRotarySwitchView setMultiple(float mMultiple) {
        this.multiple = mMultiple;
        this.distance = this.r * mMultiple;
        return this;
    }

    public LoopRotarySwitchView setAutoScrollDirection(AutoScrollDirection mAutoScrollDirection) {
        this.autoRotatinDirection = mAutoScrollDirection;
        return this;
    }

    public void createXAnimation(int from, int to, boolean start) {
        ValueAnimator valueAnimator = this.xAnimation;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.xAnimation.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(from, to);
        this.xAnimation = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.wits.ksw.launcher.view.LoopRotarySwitchView.AnonymousClass9 */

            public void onAnimationUpdate(ValueAnimator animation) {
                LoopRotarySwitchView.this.loopRotationX = ((Integer) animation.getAnimatedValue()).intValue();
                LoopRotarySwitchView.this.initView();
            }
        });
        this.xAnimation.setInterpolator(new DecelerateInterpolator());
        this.xAnimation.setDuration(2000L);
        if (start) {
            this.xAnimation.start();
        }
    }

    public ValueAnimator createZAnimation(int from, int to, boolean start) {
        ValueAnimator valueAnimator = this.zAnimation;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.zAnimation.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(from, to);
        this.zAnimation = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.wits.ksw.launcher.view.LoopRotarySwitchView.AnonymousClass10 */

            public void onAnimationUpdate(ValueAnimator animation) {
                LoopRotarySwitchView.this.loopRotationZ = ((Integer) animation.getAnimatedValue()).intValue();
                LoopRotarySwitchView.this.initView();
            }
        });
        this.zAnimation.setInterpolator(new DecelerateInterpolator());
        this.zAnimation.setDuration(2000L);
        if (start) {
            this.zAnimation.start();
        }
        return this.zAnimation;
    }

    public LoopRotarySwitchView setOrientation(int mOrientation2) {
        boolean z = true;
        if (mOrientation2 != 1) {
            z = false;
        }
        setHorizontal(z, false);
        return this;
    }

    public LoopRotarySwitchView setHorizontal(boolean horizontal2, boolean anim) {
        if (!anim) {
            if (horizontal2) {
                setLoopRotationZ(0);
            } else {
                setLoopRotationZ(90);
            }
            initView();
        } else if (horizontal2) {
            createZAnimation(getLoopRotationZ(), 0, true);
        } else {
            createZAnimation(getLoopRotationZ(), 90, true);
        }
        return this;
    }

    public LoopRotarySwitchView setLoopRotationX(int loopRotationX2) {
        this.loopRotationX = loopRotationX2;
        return this;
    }

    public LoopRotarySwitchView setLoopRotationZ(int loopRotationZ2) {
        this.loopRotationZ = loopRotationZ2;
        return this;
    }

    public int getLoopRotationX() {
        return this.loopRotationX;
    }

    public int getLoopRotationZ() {
        return this.loopRotationZ;
    }

    public ValueAnimator getRestAnimator() {
        return this.restAnimator;
    }

    public ValueAnimator getrAnimation() {
        return this.rAnimation;
    }

    public void setzAnimation(ValueAnimator zAnimation2) {
        this.zAnimation = zAnimation2;
    }

    public ValueAnimator getzAnimation() {
        return this.zAnimation;
    }

    public void setxAnimation(ValueAnimator xAnimation2) {
        this.xAnimation = xAnimation2;
    }

    public ValueAnimator getxAnimation() {
        return this.xAnimation;
    }
}
