package com.wits.ksw.launcher.model;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.launcher.bean.MediaInfo;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.pms.statuscontrol.PowerManagerApp;
import com.wits.pms.statuscontrol.VideoStatus;

public class MediaImpl {
    private static final String TAG = MediaImpl.class.getName();
    private static volatile MediaImpl singleton;
    private MediaInfo mediaInfo = new MediaInfo();
    public MutableLiveData<MediaInfo> mediaInfoMutableLiveData = new MutableLiveData<>();
    private MediaMetadataRetriever metadataRetriever;
    private String musicPath;
    private Handler uiHandler = new Handler(Looper.getMainLooper());
    private String videoPath;

    public static MediaImpl getInstance() {
        if (singleton == null) {
            synchronized (MediaImpl.class) {
                if (singleton == null) {
                    singleton = new MediaImpl();
                }
            }
        }
        return singleton;
    }

    public void initData() {
        try {
            String path = getMusicPathcString();
            int postion = getMusicPostion();
            boolean isPlay = getMusicPlayState();
            Log.d(TAG, "initDAta isplay =" + isPlay + " isstop =" + isMusicStop());
            if (!TextUtils.equals(path, this.musicPath)) {
                handleMediaPlaySeekbarAndCurrentime(postion);
                handleMediaInfo(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "initData: " + e.getMessage());
            updataNull();
        }
    }

    private int getMusicPostion() throws Exception {
        return PowerManagerApp.getManager().getStatusInt("position");
    }

    private String getMusicPathcString() throws Exception {
        return PowerManagerApp.getManager().getStatusString("path");
    }

    private String getVideoPathString() throws Exception {
        return PowerManagerApp.getManager().getStatusString("videoPath");
    }

    private boolean getVideoPlayState() throws Exception {
        return PowerManagerApp.getManager().getStatusBoolean("videoPlay");
    }

    public boolean getMusicPlayState() throws Exception {
        return PowerManagerApp.getManager().getStatusBoolean("play");
    }

    private boolean isMusicStop() throws Exception {
        return PowerManagerApp.getManager().getStatusBoolean("music_stop");
    }

    public void handleMediaPlayState(boolean play, boolean stop) {
        MediaInfo mediaInfo2 = getInstance().getMediaInfo();
        if (stop) {
            mediaInfo2.setMusicPlay(stop);
        } else {
            mediaInfo2.setMusicPlay(play);
        }
    }

    private void updataNull() {
        this.mediaInfo.setMaxProgress(0);
        this.mediaInfo.setMusicName(null);
        this.mediaInfo.setMusicAlbum(null);
        this.mediaInfo.setMusicAtist(null);
        this.mediaInfo.setPic(null);
        this.mediaInfo.setCurrentTime("0:00");
        this.mediaInfo.setTotalTime("0:00");
        this.mediaInfo.setMusicPlay(false);
        this.mediaInfo.setMaxProgressVideo(0);
        this.mediaInfo.setCurrentTimeVideo("0:00");
        this.mediaInfo.setTotalTimeVideo("0:00");
        this.mediaInfo.setVideoPlay(false);
        getInstance().setMediaInfo(this.mediaInfo);
    }

    private void releaseMetadata() {
        MediaMetadataRetriever mediaMetadataRetriever = this.metadataRetriever;
        if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
            this.metadataRetriever = null;
        }
    }

    public MediaMetadataRetriever initMediaMetadataRetriever(String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        releaseMetadata();
        if (this.metadataRetriever == null) {
            this.metadataRetriever = new MediaMetadataRetriever();
        }
        Log.i(TAG, "initMediaMetadataRetriever: " + this.metadataRetriever);
        this.metadataRetriever.setDataSource(path);
        return this.metadataRetriever;
    }

    public void setMediaInfo(MediaInfo mediaInfo2) {
        this.mediaInfo = mediaInfo2;
        this.mediaInfoMutableLiveData.setValue(mediaInfo2);
    }

    public MediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    public void setMusicPlayStatus(boolean isPlay) {
        if (this.mediaInfo != null && Boolean.TRUE.equals(this.mediaInfo.musicPlay.get()) != isPlay) {
            this.mediaInfo.setMusicPlay(isPlay);
            this.uiHandler.post(new Runnable() {
                /* class com.wits.ksw.launcher.model.$$Lambda$MediaImpl$K8A4IYVgaeZgNQO71wumgY0qj90 */

                public final void run() {
                    MediaImpl.this.lambda$setMusicPlayStatus$0$MediaImpl();
                }
            });
        }
    }

    public /* synthetic */ void lambda$setMusicPlayStatus$0$MediaImpl() {
        this.mediaInfoMutableLiveData.setValue(this.mediaInfo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0127 A[Catch:{ Exception -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0131 A[Catch:{ Exception -> 0x0180 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMediaInfo(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 417
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.launcher.model.MediaImpl.handleMediaInfo(java.lang.String):void");
    }

    public void handleVideoInfoSetPlayStatus(VideoStatus videoStatus, String path) {
        if (videoStatus != null) {
            Log.w(TAG, "handleVideoInfoSetPlayStatus:" + videoStatus.getTotalTime());
            MediaInfo mediaInfo2 = getInstance().getMediaInfo();
            mediaInfo2.setVideoPlay(videoStatus.isPlay());
            mediaInfo2.setMaxProgressVideo(videoStatus.getTotalTime());
            mediaInfo2.setProgressVideo(videoStatus.getPosition());
            String title = KswUtils.splitPathMusicName(path);
            mediaInfo2.setVideoName(title);
            Log.d("TAG", "VideoTitle:" + title);
            if (videoStatus.getTotalTime() <= 0) {
                mediaInfo2.progressPercentVideo.set(0);
            } else {
                mediaInfo2.progressPercentVideo.set(Math.round(100.0f * ((((float) videoStatus.getPosition()) * 1.0f) / ((float) videoStatus.getTotalTime()))));
            }
            mediaInfo2.setTotalTimeVideo(KswUtils.formatMusicPlayTime((long) videoStatus.getTotalTime()));
            mediaInfo2.setCurrentTimeVideo(KswUtils.formatMusicPlayTime((long) videoStatus.getPosition()));
        }
    }

    public void handleMediaPlaySeekbarAndCurrentime(int currentTime) {
        try {
            MediaInfo mediaInfo2 = getInstance().getMediaInfo();
            mediaInfo2.setProgress(currentTime);
            mediaInfo2.setCurrentTime(KswUtils.formatMusicPlayTime((long) currentTime));
            setProgressPercent(mediaInfo2);
            mediaInfo2.setRemainTime("-" + KswUtils.formatMusicPlayTimeRemain(currentTime, mediaInfo2.maxProgress.get()));
            String hightLrcRow = PowerManagerApp.getManager().getStatusString("LrcRow_HighLightContent");
            mediaInfo2.setHightLrcRow(hightLrcRow);
            Log.e("lixin_test", "handleMediaPlaySeekbarAndCurrentime: hightLrcRow " + hightLrcRow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setProgressPercent(MediaInfo mediaInfo2) {
        if (mediaInfo2 != null) {
            if (mediaInfo2.maxProgress.get() <= 0) {
                mediaInfo2.progressPercent.set(0);
                return;
            }
            mediaInfo2.progressPercent.set(Math.round(100.0f * ((((float) mediaInfo2.progress.get()) * 1.0f) / ((float) mediaInfo2.maxProgress.get()))));
        }
    }

    public static Bitmap zoomImage(Bitmap bgimage, double newWidth, double newHeight) {
        float width = (float) bgimage.getWidth();
        float height = (float) bgimage.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) newWidth) / width, ((float) newHeight) / height);
        return Bitmap.createBitmap(bgimage, 0, 0, (int) width, (int) height, matrix, true);
    }

    public static Bitmap getShapeBitmap(Bitmap bitmap) {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new ColorMatrix().set(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 20.0f, 0.0f, 1.0f, 0.0f, 0.0f, 20.0f, 0.0f, 0.0f, 1.0f, 0.0f, 20.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        return bmp;
    }

    private Drawable zoomDrawable(Drawable drawable, int w, int h) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap oldbmp = drawableToBitmap(drawable);
        Matrix matrix = new Matrix();
        matrix.postScale(((float) w) / ((float) width), ((float) h) / ((float) height));
        return new BitmapDrawable((Resources) null, Bitmap.createBitmap(oldbmp, 0, 0, width, height, matrix, true));
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap.Config config;
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    public static Bitmap blurBitmap(Bitmap bitmap, Context context) {
        Bitmap outBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation allIn = Allocation.createFromBitmap(rs, bitmap);
        Allocation allOut = Allocation.createFromBitmap(rs, outBitmap);
        blurScript.setRadius(25.0f);
        blurScript.setInput(allIn);
        blurScript.forEach(allOut);
        allOut.copyTo(outBitmap);
        bitmap.recycle();
        rs.destroy();
        return outBitmap;
    }
}
