package com.wits.ksw.launcher.bmw_id8_ui;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.SkinAppCompatDelegateImpl;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bmw_id8_ui.fragment.ID8FragmentHelper;
import com.wits.ksw.launcher.bmw_id8_ui.listener.BarOnDragListener;
import com.wits.ksw.launcher.utils.KswUtils;
import java.util.Iterator;
import java.util.List;

public class ID8EditActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static int mScreenWidth;
    private float autoScrollLeftPosition;
    private float autoScrollRightPosition;
    private int currentScrollX;
    private int currentScrollY;
    ImageView ivLeft1;
    ImageView ivLeft2;
    ImageView ivLeft3;
    ImageView ivLeft4;
    private LinearLayout llContainer;
    LinearLayout llLeft1;
    LinearLayout llLeft2;
    LinearLayout llLeft3;
    LinearLayout llLeft4;
    private int offsetX = 20;
    private HorizontalScrollView scrollView;
    TextView tvLeft1;
    TextView tvLeft2;
    TextView tvLeft3;
    TextView tvLeft4;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KswUtils.setFull(getWindow());
        setContentView(R.layout.activity_id8_launcher_edit);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.scrollView);
        this.scrollView = horizontalScrollView;
        horizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            /* class com.wits.ksw.launcher.bmw_id8_ui.ID8EditActivity.AnonymousClass1 */

            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                ID8EditActivity.this.currentScrollX = scrollX;
                ID8EditActivity.this.currentScrollY = scrollY;
            }
        });
        this.scrollView.setOnDragListener(new View.OnDragListener() {
            /* class com.wits.ksw.launcher.bmw_id8_ui.ID8EditActivity.AnonymousClass2 */

            public boolean onDrag(View v, DragEvent event) {
                Log.w(ID8EditActivity.TAG, "scrollView onDrag: " + event.getX());
                return false;
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_container);
        this.llContainer = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.bmw_id8_ui.ID8EditActivity.AnonymousClass3 */

            public void onClick(View v) {
                ID8EditActivity.this.finish();
            }
        });
        this.llLeft1 = (LinearLayout) findViewById(R.id.ll_left_1);
        this.llLeft2 = (LinearLayout) findViewById(R.id.ll_left_2);
        this.llLeft3 = (LinearLayout) findViewById(R.id.ll_left_3);
        this.llLeft4 = (LinearLayout) findViewById(R.id.ll_left_4);
        this.llLeft1.setBackground(null);
        this.llLeft2.setBackground(null);
        this.llLeft3.setBackground(null);
        this.llLeft4.setBackground(null);
        LinearLayout llLeftBarContainer = (LinearLayout) findViewById(R.id.ll_left_bar_container);
        llLeftBarContainer.setClickable(false);
        llLeftBarContainer.setFocusable(false);
        this.ivLeft1 = (ImageView) findViewById(R.id.iv_left_1);
        this.ivLeft2 = (ImageView) findViewById(R.id.iv_left_2);
        this.ivLeft3 = (ImageView) findViewById(R.id.iv_left_3);
        this.ivLeft4 = (ImageView) findViewById(R.id.iv_left_4);
        this.tvLeft1 = (TextView) findViewById(R.id.tv_left_1);
        this.tvLeft2 = (TextView) findViewById(R.id.tv_left_2);
        this.tvLeft3 = (TextView) findViewById(R.id.tv_left_3);
        this.tvLeft4 = (TextView) findViewById(R.id.tv_left_4);
        initLeftIcon(this.ivLeft2, this.tvLeft2, ID8LauncherConstants.leftIcon2);
        initLeftIcon(this.ivLeft3, this.tvLeft3, ID8LauncherConstants.leftIcon3);
        initLeftIcon(this.ivLeft4, this.tvLeft4, ID8LauncherConstants.leftIcon4);
        ID8FragmentHelper.getInstance(this).locateFragmentPosition();
        BarOnDragListener barOnDragListener = new BarOnDragListener(this);
        this.llLeft2.setOnDragListener(barOnDragListener);
        this.llLeft3.setOnDragListener(barOnDragListener);
        this.llLeft4.setOnDragListener(barOnDragListener);
        int i = getResources().getDisplayMetrics().widthPixels;
        mScreenWidth = i;
        this.autoScrollLeftPosition = ((float) i) * 0.2f;
        this.autoScrollRightPosition = ((float) i) * 0.9f;
        Log.w(TAG, "onCreate: mScreenWidth : " + mScreenWidth);
        Log.w(TAG, "onCreate: autoScrollLeftPosition : " + this.autoScrollLeftPosition);
        Log.w(TAG, "onCreate: autoScrollRightPosition : " + this.autoScrollRightPosition);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void initLeftIcon(ImageView iv, TextView tv, String name) {
        char c;
        int iconRes = -1;
        int nameRes = -1;
        switch (name.hashCode()) {
            case -1591043536:
                if (name.equals("SETTING")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1409845903:
                if (name.equals("NAVIGATE")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 73532672:
                if (name.equals("MODUS")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 73725445:
                if (name.equals("MUSIC")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 76105038:
                if (name.equals("PHONE")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 81665115:
                if (name.equals("VIDEO")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 741767578:
                if (name.equals("CAR INFO")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1738734196:
                if (name.equals("DASHBOARD")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1941423060:
                if (name.equals("WEATHER")) {
                    c = 1;
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
                iconRes = R.drawable.id8_main_left_icon_navi;
                nameRes = R.string.ksw_id8_abbr_tel_navigate;
                break;
            case 1:
                iconRes = R.drawable.id8_main_left_icon_weather;
                nameRes = R.string.ksw_id8_weather;
                break;
            case 2:
                iconRes = R.drawable.id8_main_left_icon_music;
                nameRes = R.string.ksw_id8_music;
                break;
            case 3:
                iconRes = R.drawable.id8_main_left_icon_car;
                nameRes = R.string.ksw_id8_abbr_car_info;
                break;
            case 4:
                iconRes = R.drawable.id8_main_left_icon_modus;
                nameRes = R.string.ksw_id8_modus;
                break;
            case 5:
                iconRes = R.drawable.id8_main_left_icon_bt;
                nameRes = R.string.ksw_id8_abbr_tel;
                break;
            case 6:
                iconRes = R.drawable.id8_main_left_icon_dashboard;
                nameRes = R.string.ksw_id8_dashboard;
                break;
            case 7:
                iconRes = R.drawable.id8_main_left_icon_set;
                nameRes = R.string.ksw_id8_abbr_setting;
                break;
            case '\b':
                iconRes = R.drawable.id8_main_left_icon_video;
                nameRes = R.string.ksw_id8_abbr_hd_video;
                break;
        }
        if (iconRes != -1) {
            tv.setText(getString(nameRes));
            iv.setImageBitmap(BitmapFactory.decodeResource(getResources(), iconRes));
        }
    }

    public void sort(String dragName, String releaseName) {
        List<String> nameList = ID8LauncherConstants.nameList;
        if (!dragName.equals(releaseName)) {
            if (!nameList.remove(dragName)) {
                Toast.makeText(this, "排序异常，请重试。occur error,please try again.", 0).show();
                return;
            }
            int releasePosition = -1;
            Iterator<String> it = nameList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(releaseName)) {
                        releasePosition = nameList.indexOf(releaseName);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (releasePosition == -1) {
                Toast.makeText(this, "排序异常，请重试。occur error,please try again.", 0).show();
                return;
            }
            nameList.add(releasePosition, dragName);
            int tempX = this.currentScrollX;
            int tempY = this.currentScrollY;
            ID8FragmentHelper.getInstance(this).locateFragmentPosition();
            this.scrollView.scrollTo(tempX, tempY);
        }
    }

    public void emptyClick(View view) {
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        ID8LauncherConstants.saveSystemCardSeq();
    }

    @Override // android.support.v7.app.AppCompatActivity
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.w(TAG, "dispatchTouchEvent: ");
        return super.dispatchTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent event) {
        Log.w(TAG, "onTouchEvent: ");
        return super.onTouchEvent(event);
    }

    public void checkAutoScroll(float fingerX) {
        if (this.autoScrollLeftPosition >= fingerX) {
            if (fingerX >= 0.0f) {
                int i = this.currentScrollX - this.offsetX;
                this.currentScrollX = i;
                this.scrollView.scrollTo(i, this.currentScrollY);
            }
        } else if (fingerX >= this.autoScrollRightPosition && fingerX <= ((float) mScreenWidth)) {
            int i2 = this.currentScrollX + this.offsetX;
            this.currentScrollX = i2;
            this.scrollView.scrollTo(i2, this.currentScrollY);
        }
    }
}
