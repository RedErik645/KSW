package com.wits.ksw.launcher.view.id8ug.fragment;

import android.animation.ValueAnimator;
import android.databinding.Observable;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.databinding.FragmentEvoid8MainCarSpeedBinding;
import com.wits.ksw.launcher.model.McuImpl;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import skin.support.content.res.SkinCompatResources;

public class Id8UgCarSpeedFragment extends Id8UgBaseFragment {
    private static final String TAG = Id8UgCarSpeedFragment.class.getName();
    AnimationDrawable aDrawable;
    private FragmentEvoid8MainCarSpeedBinding binding;
    private int carSaveSpeed = 0;
    Observable.OnPropertyChangedCallback changedCallback = new Observable.OnPropertyChangedCallback() {
        /* class com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarSpeedFragment.AnonymousClass1 */

        @Override // android.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable sender, int propertyId) {
            int carSpeed = 0;
            if (McuImpl.getInstance().carInfo.speed != null) {
                carSpeed = McuImpl.getInstance().carInfo.speed.get();
            }
            if (Id8UgCarSpeedFragment.this.carSaveSpeed != carSpeed) {
                Log.i(Id8UgCarSpeedFragment.TAG, "onChanged: carSpeed = " + carSpeed + " carNowSpeed = " + Id8UgCarSpeedFragment.this.carSaveSpeed);
                Id8UgCarSpeedFragment id8UgCarSpeedFragment = Id8UgCarSpeedFragment.this;
                id8UgCarSpeedFragment.setSpeedData(carSpeed, id8UgCarSpeedFragment.carSaveSpeed);
                Id8UgCarSpeedFragment id8UgCarSpeedFragment2 = Id8UgCarSpeedFragment.this;
                boolean isSpeedAnimationChange = id8UgCarSpeedFragment2.isSpeedAnimationChange(carSpeed, id8UgCarSpeedFragment2.carSaveSpeed);
                Id8UgCarSpeedFragment.this.carSaveSpeed = carSpeed;
                if (isSpeedAnimationChange) {
                    Id8UgCarSpeedFragment.this.initFrameAnimation();
                }
            }
        }
    };
    private ImageView imageView;
    private CountDownTimer mAutoPlayTimer;
    private TextView speedTv;
    private TextView speedUnitTv;
    private ValueAnimator valueAnimator;
    private View[] views = new View[3];

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public String setFragmentTag() {
        return Id8UgConstants.ID8UG_FRAGMENT_CAR_SPEED;
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public void initBaseData() {
        super.initBaseData();
        this.imageView = this.binding.ivCarSpeed;
        this.speedTv = this.binding.speedTv;
        this.speedUnitTv = this.binding.speedUnitTv;
        McuImpl.getInstance().carInfo.speed.addOnPropertyChangedCallback(this.changedCallback);
        setSpeedData(0, this.carSaveSpeed);
        initFrameAnimation();
        this.views[0] = this.binding.id8UgCarStatusBlack;
        this.views[1] = this.binding.id8UgCarStatusWhite;
        this.views[2] = this.binding.id8UgCarStatusRed;
        setCarColorStatus();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public void initMainActivityData() {
        super.initMainActivityData();
        setListener();
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        TextView textView;
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && (textView = this.speedUnitTv) != null) {
            textView.setText(KswUtils.ismph() ? R.string.speed_unit_en : R.string.speed_unit_cn);
        }
    }

    private void setCarColorStatus() {
        int i;
        int carColorStatus = SpfUtils.getInt(Id8UgConstants.ID8UG_CAR_COLOR_STATUS, 0);
        Log.i(TAG, "setCarColorStatus: carColorStatus = " + carColorStatus);
        int i2 = 0;
        while (true) {
            View[] viewArr = this.views;
            boolean z = true;
            if (i2 >= viewArr.length) {
                break;
            }
            View view = viewArr[i2];
            if (i2 != carColorStatus) {
                z = false;
            }
            view.setSelected(z);
            i2++;
        }
        ImageView imageView2 = this.binding.id8UgCarModel;
        if (carColorStatus == 0) {
            i = R.drawable.evoid8_car_model_black;
        } else {
            i = carColorStatus == 1 ? R.drawable.evoid8_car_model_white : R.drawable.evoid8_car_model_red;
        }
        imageView2.setImageResource(i);
    }

    private void setListener() {
        this.binding.id8UgCarChange.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarSpeedFragment$0rqlMLUSJ8sLKmFgmT5zqGLXdg */

            public final void onClick(View view) {
                Id8UgCarSpeedFragment.this.lambda$setListener$0$Id8UgCarSpeedFragment(view);
            }
        });
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarSpeedFragment$Mw0yHwqGYLE2e3bMo8brdFb60RA */

            public final void onClick(View view) {
                Id8UgCarSpeedFragment.this.lambda$setListener$1$Id8UgCarSpeedFragment(view);
            }
        });
        this.binding.id8UgCarChangeWhite.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarSpeedFragment$FTbvldT179PVa4yaEwqADpsP8c */

            public final void onClick(View view) {
                Id8UgCarSpeedFragment.this.lambda$setListener$2$Id8UgCarSpeedFragment(view);
            }
        });
        this.binding.id8UgCarChangeBlack.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarSpeedFragment$RSqVWGZPKGaNr1yc7743mEnaJM */

            public final void onClick(View view) {
                Id8UgCarSpeedFragment.this.lambda$setListener$3$Id8UgCarSpeedFragment(view);
            }
        });
        this.binding.id8UgCarChangeRed.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarSpeedFragment$NrymWI25PynzQsxbwY6s3AZzYsM */

            public final void onClick(View view) {
                Id8UgCarSpeedFragment.this.lambda$setListener$4$Id8UgCarSpeedFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$setListener$0$Id8UgCarSpeedFragment(View view) {
        showCarChangeLayout();
    }

    public /* synthetic */ void lambda$setListener$1$Id8UgCarSpeedFragment(View view) {
        hideCarChangeLayout();
    }

    public /* synthetic */ void lambda$setListener$2$Id8UgCarSpeedFragment(View view) {
        SpfUtils.saveData(Id8UgConstants.ID8UG_CAR_COLOR_STATUS, 1);
        setCarColorStatus();
        hideCarChangeLayout();
    }

    public /* synthetic */ void lambda$setListener$3$Id8UgCarSpeedFragment(View view) {
        SpfUtils.saveData(Id8UgConstants.ID8UG_CAR_COLOR_STATUS, 0);
        setCarColorStatus();
        hideCarChangeLayout();
    }

    public /* synthetic */ void lambda$setListener$4$Id8UgCarSpeedFragment(View view) {
        SpfUtils.saveData(Id8UgConstants.ID8UG_CAR_COLOR_STATUS, 2);
        setCarColorStatus();
        hideCarChangeLayout();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hideCarChangeLayout() {
        if (this.binding.id8UgCarChangeLayout.getVisibility() == 0) {
            this.binding.id8UgCarChangeLayout.setVisibility(8);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(400);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(400);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            this.binding.id8UgCarChangeLayout.startAnimation(animationSet);
        }
    }

    private void showCarChangeLayout() {
        this.binding.id8UgCarChangeLayout.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(400);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(400);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.binding.id8UgCarChangeLayout.startAnimation(animationSet);
        startAutoTimer();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.view.id8ug.fragment.Id8UgBaseFragment
    public ViewBinding createDataBinding(LayoutInflater inflater, ViewGroup container) {
        FragmentEvoid8MainCarSpeedBinding inflate = FragmentEvoid8MainCarSpeedBinding.inflate(inflater, container, false);
        this.binding = inflate;
        return inflate;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSpeedData(int nowCarSpeed, int oldCarSpeed) {
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(oldCarSpeed, nowCarSpeed);
        this.valueAnimator = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.wits.ksw.launcher.view.id8ug.fragment.$$Lambda$Id8UgCarSpeedFragment$ELlKmBW6lt4eNpnmTHHE04Trmsk */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Id8UgCarSpeedFragment.this.lambda$setSpeedData$5$Id8UgCarSpeedFragment(valueAnimator);
            }
        });
        this.valueAnimator.setDuration(250L);
        this.valueAnimator.start();
    }

    public /* synthetic */ void lambda$setSpeedData$5$Id8UgCarSpeedFragment(ValueAnimator animation) {
        this.speedTv.setText(animation.getAnimatedValue().toString());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isSpeedAnimationChange(int newSpeed, int oldSpeed) {
        int nowCarSpeed = newSpeed;
        int oldCarSpeed = oldSpeed;
        if (KswUtils.ismph()) {
            nowCarSpeed = (int) (((double) nowCarSpeed) * 1.609d);
            oldCarSpeed = (int) (((double) oldCarSpeed) * 1.609d);
        }
        if (nowCarSpeed == oldCarSpeed) {
            return false;
        }
        if (nowCarSpeed > 110 && oldCarSpeed <= 110) {
            return true;
        }
        if (nowCarSpeed <= 110 && nowCarSpeed > 70 && (oldCarSpeed > 110 || oldCarSpeed <= 70)) {
            return true;
        }
        if (nowCarSpeed <= 70 && nowCarSpeed > 30 && (oldCarSpeed > 70 || oldCarSpeed <= 30)) {
            return true;
        }
        if (nowCarSpeed <= 30 && nowCarSpeed > 0 && (oldCarSpeed > 30 || oldCarSpeed <= 0)) {
            return true;
        }
        if (nowCarSpeed != 0 || oldCarSpeed <= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initFrameAnimation() {
        int duration;
        Log.i(TAG, "initFrameAnimation: carSaveSpeed = " + this.carSaveSpeed + " carModel = " + SpfUtils.getInt(Id8UgConstants.ID8UG_FRAGMENT_CAR_SPEED_MODEL, 0));
        AnimationDrawable animationDrawable = this.aDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        if (this.carSaveSpeed <= 0) {
            this.imageView.setImageResource(R.drawable.evoid8_speed_card);
            return;
        }
        int speed = this.carSaveSpeed;
        if (KswUtils.ismph()) {
            speed = (int) (((double) speed) * 1.609d);
        }
        if (speed > 110) {
            duration = 50;
        } else if (speed > 70) {
            duration = 85;
        } else if (speed > 30) {
            duration = 115;
        } else {
            duration = Constants.DEFAULT_SIZE;
        }
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        this.aDrawable = animationDrawable2;
        animationDrawable2.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_1), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_2), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_3), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_4), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_5), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_6), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_7), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_8), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_9), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_10), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_11), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_12), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_13), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_14), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_15), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_16), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_17), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_18), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_19), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_20), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_21), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_22), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_23), duration);
        this.aDrawable.addFrame(SkinCompatResources.getDrawable(getContext(), R.drawable.evoid8_car_speed_bg_24), duration);
        this.imageView.setImageResource(0);
        this.imageView.setImageDrawable(this.aDrawable);
        this.aDrawable.start();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        McuImpl.getInstance().carInfo.speed.removeOnPropertyChangedCallback(this.changedCallback);
        cancelAutoTimer();
    }

    public void startAutoTimer() {
        Log.d(TAG, "startAutoTimer");
        cancelAutoTimer();
        if (this.mAutoPlayTimer == null) {
            this.mAutoPlayTimer = new CountDownTimer(10000, 1000) {
                /* class com.wits.ksw.launcher.view.id8ug.fragment.Id8UgCarSpeedFragment.AnonymousClass2 */

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    Log.i(Id8UgCarSpeedFragment.TAG, "startAutoTimer onFinish: ");
                    Id8UgCarSpeedFragment.this.hideCarChangeLayout();
                }
            };
        }
        this.mAutoPlayTimer.start();
    }

    public void cancelAutoTimer() {
        Log.d(TAG, "cancelAutoTimer");
        CountDownTimer countDownTimer = this.mAutoPlayTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
