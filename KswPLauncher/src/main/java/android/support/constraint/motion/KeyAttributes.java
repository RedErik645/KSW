package android.support.constraint.motion;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.constraint.R;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttribute";
    private float mAlpha = Float.NaN;
    private int mCurveFit = -1;
    private float mElevation = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mProgress = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private String mTransitionEasing;
    private float mTransitionPathRotate = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private boolean mVisibility = false;

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new HashMap();
    }

    @Override // android.support.constraint.motion.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R.styleable.KeyAttribute));
    }

    /* access modifiers changed from: package-private */
    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // android.support.constraint.motion.Key
    public void getAttributeNames(HashSet<String> attributes) {
        if (!Float.isNaN(this.mAlpha)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            attributes.add("rotation");
        }
        if (!Float.isNaN(this.mRotationX)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.mPivotX)) {
            attributes.add("transformPivotX");
        }
        if (!Float.isNaN(this.mPivotY)) {
            attributes.add("transformPivotY");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            attributes.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleX)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            attributes.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                attributes.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    @Override // android.support.constraint.motion.Key
    public void setInterpolation(HashMap<String, Integer> interpolation) {
        if (this.mCurveFit != -1) {
            if (!Float.isNaN(this.mAlpha)) {
                interpolation.put("alpha", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mElevation)) {
                interpolation.put("elevation", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotation)) {
                interpolation.put("rotation", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotationX)) {
                interpolation.put("rotationX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotationY)) {
                interpolation.put("rotationY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mPivotX)) {
                interpolation.put("transformPivotX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mPivotY)) {
                interpolation.put("transformPivotY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationX)) {
                interpolation.put("translationX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationY)) {
                interpolation.put("translationY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationZ)) {
                interpolation.put("translationZ", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTransitionPathRotate)) {
                interpolation.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mScaleX)) {
                interpolation.put("scaleX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mScaleY)) {
                interpolation.put("scaleY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mProgress)) {
                interpolation.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.mCurveFit));
            }
            if (this.mCustomConstraints.size() > 0) {
                Iterator it = this.mCustomConstraints.keySet().iterator();
                while (it.hasNext()) {
                    interpolation.put("CUSTOM," + ((String) it.next()), Integer.valueOf(this.mCurveFit));
                }
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (r1.equals("elevation") != false) goto L_0x00e8;
     */
    @Override // android.support.constraint.motion.Key
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addValues(java.util.HashMap<java.lang.String, android.support.constraint.motion.SplineSet> r8) {
        /*
        // Method dump skipped, instructions count: 590
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.motion.KeyAttributes.addValues(java.util.HashMap):void");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.constraint.motion.Key
    public void setValue(String tag, Object value) {
        char c;
        switch (tag.hashCode()) {
            case -1913008125:
                if (tag.equals("motionProgress")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1812823328:
                if (tag.equals("transitionEasing")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (tag.equals("rotationX")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (tag.equals("rotationY")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (tag.equals("translationX")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (tag.equals("translationY")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -987906986:
                if (tag.equals("pivotX")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -987906985:
                if (tag.equals("pivotY")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (tag.equals("scaleX")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (tag.equals("scaleY")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (tag.equals("rotation")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (tag.equals("elevation")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (tag.equals("transitionPathRotate")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (tag.equals("alpha")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 579057826:
                if (tag.equals("curveFit")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1317633238:
                if (tag.equals("mTranslationZ")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1941332754:
                if (tag.equals("visibility")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.mAlpha = toFloat(value);
                return;
            case 1:
                this.mCurveFit = toInt(value);
                return;
            case 2:
                this.mElevation = toFloat(value);
                return;
            case 3:
                this.mProgress = toFloat(value);
                return;
            case 4:
                this.mRotation = toFloat(value);
                return;
            case 5:
                this.mRotationX = toFloat(value);
                return;
            case 6:
                this.mRotationY = toFloat(value);
                return;
            case 7:
                this.mPivotX = toFloat(value);
                return;
            case '\b':
                this.mPivotY = toFloat(value);
                return;
            case '\t':
                this.mScaleX = toFloat(value);
                return;
            case '\n':
                this.mScaleY = toFloat(value);
                return;
            case 11:
                this.mTransitionEasing = value.toString();
                return;
            case '\f':
                this.mVisibility = toBoolean(value);
                return;
            case '\r':
                this.mTransitionPathRotate = toFloat(value);
                return;
            case 14:
                this.mTranslationX = toFloat(value);
                return;
            case 15:
                this.mTranslationY = toFloat(value);
                return;
            case 16:
                this.mTranslationZ = toFloat(value);
                return;
            default:
                return;
        }
    }

    private static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        public static void read(KeyAttributes c, TypedArray a) {
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                switch (mAttrMap.get(attr)) {
                    case 1:
                        c.mAlpha = a.getFloat(attr, c.mAlpha);
                        break;
                    case 2:
                        c.mElevation = a.getDimension(attr, c.mElevation);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(attr) + "   " + mAttrMap.get(attr));
                        break;
                    case 4:
                        c.mRotation = a.getFloat(attr, c.mRotation);
                        break;
                    case 5:
                        c.mRotationX = a.getFloat(attr, c.mRotationX);
                        break;
                    case 6:
                        c.mRotationY = a.getFloat(attr, c.mRotationY);
                        break;
                    case 7:
                        c.mScaleX = a.getFloat(attr, c.mScaleX);
                        break;
                    case 8:
                        c.mTransitionPathRotate = a.getFloat(attr, c.mTransitionPathRotate);
                        break;
                    case 9:
                        c.mTransitionEasing = a.getString(attr);
                        break;
                    case 10:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (a.peekValue(attr).type == 3) {
                                c.mTargetString = a.getString(attr);
                                break;
                            } else {
                                c.mTargetId = a.getResourceId(attr, c.mTargetId);
                                break;
                            }
                        } else {
                            c.mTargetId = a.getResourceId(attr, c.mTargetId);
                            if (c.mTargetId == -1) {
                                c.mTargetString = a.getString(attr);
                                break;
                            } else {
                                break;
                            }
                        }
                    case 12:
                        c.mFramePosition = a.getInt(attr, c.mFramePosition);
                        break;
                    case 13:
                        c.mCurveFit = a.getInteger(attr, c.mCurveFit);
                        break;
                    case 14:
                        c.mScaleY = a.getFloat(attr, c.mScaleY);
                        break;
                    case 15:
                        c.mTranslationX = a.getDimension(attr, c.mTranslationX);
                        break;
                    case 16:
                        c.mTranslationY = a.getDimension(attr, c.mTranslationY);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            c.mTranslationZ = a.getDimension(attr, c.mTranslationZ);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        c.mProgress = a.getFloat(attr, c.mProgress);
                        break;
                    case 19:
                        c.mPivotX = a.getDimension(attr, c.mPivotX);
                        break;
                    case 20:
                        c.mPivotY = a.getDimension(attr, c.mPivotY);
                        break;
                }
            }
        }
    }
}
