package com.wits.ksw.settings.utlis_view;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.ContactsContract;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.KswSystemProperties;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Properties;

public class UtilsInfo {
    public static final String ChIP_NAME = "/sys/devices/soc0/chip_name";
    private ContactsContract.CommonDataKinds.Phone mPhone;

    public static String getRAMSize(Context context) {
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(info);
        int ramSize = (int) (info.totalMem / 1073741824);
        if (info.totalMem % 1073741824 != 0) {
            ramSize++;
        }
        if (!Build.VERSION.RELEASE.equals("10")) {
            return ramSize + "GB";
        }
        if (getMemoryValue() == null) {
            return ramSize + "GB";
        }
        return getMemoryValue() + "GB";
    }

    public static String getMemoryValue() {
        if (!new File("/mnt/vendor/persist/OEM/memoryvalue_501a").exists()) {
            return null;
        }
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("/mnt/vendor/persist/OEM/memoryvalue_501a");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("memoryvalue");
    }

    public static String getROMSize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        statFs.getBlockCountLong();
        long availROMSize = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        return (availROMSize / 1073741824) + "." + ((availROMSize % 1073741824) / 10000000) + "GB/" + getTotalMemSizeInfo();
    }

    private static String getTotalMemSizeInfo() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        long size = stat.getBlockCountLong() * stat.getBlockSizeLong();
        long[] size_mapping_table = {2 * 1073741824, 4 * 1073741824, 8 * 1073741824, 16 * 1073741824, 32 * 1073741824, 64 * 1073741824, 128 * 1073741824, 256 * 1073741824, 512 * 1073741824};
        String[] size_mapping_table_str = {"2GB", "4GB", "8GB", "16GB", "32GB", "64GB", "128GB", "256GB", "512GB"};
        int i = 0;
        while (i < size_mapping_table.length && size > size_mapping_table[i]) {
            i++;
        }
        if (i == size_mapping_table.length) {
            i--;
        }
        return size_mapping_table_str[i];
    }

    public static String getBaseband_Ver() {
        return SystemProperties.get("gsm.version.baseband");
    }

    public static String getIMEI() {
        return SystemProperties.get("persist.wits.imei");
    }

    public static String getVersion(int index) {
        String[] version = {"null", "null", "null", "null"};
        try {
            BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/version"), 8192);
            version[0] = localBufferedReader.readLine().split("\\s+")[2];
            localBufferedReader.close();
        } catch (IOException e) {
        }
        version[1] = Build.VERSION.RELEASE;
        version[2] = Build.MODEL;
        version[3] = "Witstek-" + changeM785();
        return version[index];
    }

    public static int dip2px(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String getSettingsVer(Context context) {
        String version;
        String pingtai;
        String str = Build.VERSION.RELEASE;
        String realVer = changeVersion();
        if (!TextUtils.isEmpty(getBaseband_Ver())) {
            getBaseband_Ver().substring(0, 4);
            int index_NA = getBaseband_Ver().indexOf("NA");
            int index_platform_M506 = getBaseband_Ver().indexOf("M506");
            int index_platform_M501 = getBaseband_Ver().indexOf("M501");
            int index_platform_8953 = getBaseband_Ver().indexOf("8953");
            int index_platform_8937 = getBaseband_Ver().indexOf("8937");
            int index_platform_8917 = getBaseband_Ver().indexOf("8917");
            int index_platform_511 = getBaseband_Ver().indexOf("M511");
            int index_platform_600 = getBaseband_Ver().indexOf("M600");
            int index_platform_450 = getBaseband_Ver().indexOf("SDM450");
            int index_platform_700 = getBaseband_Ver().indexOf("M700");
            if (index_platform_M506 > -1) {
                pingtai = "M506";
            } else if (index_platform_8917 > -1) {
                pingtai = "M506";
            } else if (index_platform_450 > -1) {
                pingtai = "501A-";
            } else if (index_platform_M501 > -1) {
                pingtai = "8953";
            } else if (index_platform_8953 > -1) {
                pingtai = "8953";
            } else if (index_platform_8937 > -1) {
                pingtai = "8937";
            } else if (index_platform_511 > -1) {
                pingtai = "662";
            } else if (index_platform_600 > -1) {
                if (getChipName(ChIP_NAME).equals("SM_KAMORTA")) {
                    pingtai = "460";
                } else {
                    pingtai = "662";
                }
            } else if (index_platform_700 <= -1) {
                pingtai = "8953";
            } else if (KswSystemProperties.getBoolean("cpuinfo.isM785", false)) {
                pingtai = "685";
            } else {
                pingtai = "680";
            }
            String version2 = realVer + "-" + pingtai;
            if (index_NA > -1) {
                if (index_platform_M501 > -1) {
                    version = realVer + "-" + pingtai + "NA-1";
                } else {
                    version = realVer + "-" + pingtai + "NA";
                }
            } else if (index_platform_M501 > -1) {
                version = realVer + "-" + pingtai + "EA-1";
            } else {
                version = realVer + "-" + pingtai + "EA";
            }
        } else {
            version = realVer;
        }
        return "Witstek-" + version;
    }

    public static String getChipName(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                stringBuilder.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String getSettingsVersion(Context context) {
        String settingsVer;
        String pingtai;
        String realVer = changeVersion();
        if (!TextUtils.isEmpty(getBaseband_Ver())) {
            getBaseband_Ver().substring(0, 4);
            int index_NA = getBaseband_Ver().indexOf("NA");
            int index_platform_M506 = getBaseband_Ver().indexOf("M506");
            int index_platform_M501 = getBaseband_Ver().indexOf("M501");
            int index_platform_8953 = getBaseband_Ver().indexOf("8953");
            int index_platform_8937 = getBaseband_Ver().indexOf("8937");
            int index_platform_8917 = getBaseband_Ver().indexOf("8917");
            int index_platform_511 = getBaseband_Ver().indexOf("M511");
            int index_platform_600 = getBaseband_Ver().indexOf("M600");
            int index_platform_450 = getBaseband_Ver().indexOf("SDM450");
            int index_platform_700 = getBaseband_Ver().indexOf("M700");
            if (index_platform_M506 > -1) {
                pingtai = "M506";
            } else if (index_platform_8917 > -1) {
                pingtai = "M506";
            } else if (index_platform_450 > -1) {
                pingtai = "501A-";
            } else if (index_platform_M501 > -1) {
                pingtai = "8953";
            } else if (index_platform_8953 > -1) {
                pingtai = "8953";
            } else if (index_platform_8937 > -1) {
                pingtai = "8937";
            } else if (index_platform_511 > -1) {
                pingtai = "662";
            } else if (index_platform_600 > -1) {
                if (getChipName(ChIP_NAME).equals("SM_KAMORTA")) {
                    pingtai = "460";
                } else {
                    pingtai = "662";
                }
            } else if (index_platform_700 <= -1) {
                pingtai = "8953";
            } else if (KswSystemProperties.getBoolean("cpuinfo.isM785", false)) {
                pingtai = "685";
            } else {
                pingtai = "680";
            }
            context.getString(R.string.audi_set_sys_info_system_ver, realVer + "-" + pingtai);
            if (index_NA > -1) {
                if (index_platform_M501 > -1) {
                    settingsVer = realVer + "-" + pingtai + "NA-1";
                } else {
                    settingsVer = realVer + "-" + pingtai + "NA";
                }
            } else if (index_platform_M501 > -1) {
                settingsVer = realVer + "-" + pingtai + "EA-1";
            } else {
                settingsVer = realVer + "-" + pingtai + "EA";
            }
        } else {
            settingsVer = changeVersion();
        }
        return "Witstek-" + settingsVer;
    }

    public static String changeVersion() {
        String targetVer = SystemProperties.get("ksw_android11");
        if (targetVer == null || targetVer.isEmpty()) {
            return Build.VERSION.RELEASE;
        }
        if (Integer.parseInt(targetVer) > Integer.parseInt(Build.VERSION.RELEASE)) {
            return targetVer;
        }
        return Build.VERSION.RELEASE;
    }

    public static String changeM785() {
        boolean isM785 = KswSystemProperties.getBoolean("cpuinfo.isM785", false);
        boolean isM606 = KswSystemProperties.getBoolean("cpuinfo.isM606", false);
        if (isM785) {
            StringBuilder sb = new StringBuilder(Build.DISPLAY);
            sb.replace(6, 10, "M785");
            return ((Object) sb) + "";
        } else if (!isM606) {
            return Build.DISPLAY;
        } else {
            StringBuilder sb2 = new StringBuilder(Build.DISPLAY);
            sb2.replace(6, 10, "M606");
            return ((Object) sb2) + "";
        }
    }

    public static String getCpuInfo(Context context) {
        String deviceName = Build.DISPLAY.substring(6, 10);
        if (deviceName.equals("M600")) {
            if (KswSystemProperties.getBoolean("cpuinfo.isM606", false)) {
                return context.getString(R.string.qualcomm_chip_type_M606);
            }
            return context.getString(R.string.qualcomm_chip_type_M600);
        } else if (!deviceName.equals("M700")) {
            return "";
        } else {
            if (KswSystemProperties.getBoolean("cpuinfo.isM785", false)) {
                return context.getString(R.string.qualcomm_chip_type_M785);
            }
            return context.getString(R.string.qualcomm_chip_type_M700);
        }
    }

    public static String getDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(1);
        int month = calendar.get(2) + 1;
        int day = calendar.get(5);
        if (year >= 2019) {
            return year + "-" + month + "-" + day;
        }
        return "null";
    }

    public static void showQRCode(Context context) {
        File file = new File("/mnt/vendor/persist/OEM/qrCode.jpg");
        DialogViews dialogViews = new DialogViews(context);
        if (file.exists()) {
            dialogViews.qrCode(BitmapFactory.decodeFile(file.getPath()));
        } else if (generateQRCode(context, true)) {
            dialogViews.qrCode(BitmapFactory.decodeFile(file.getPath()));
        }
    }

    public static boolean generateQRCode(Context context, boolean show) {
        if (!"null".equals(getDate())) {
            saveBitmap("qrCode.jpg", createQRCodeBitmap(getIMEI() + "," + getDate(), 300, 300, "", "", Id9AlsConstants.ID9ALS_SELECT_MODEL_VITALITY, ViewCompat.MEASURED_STATE_MASK, -1), context);
            return true;
        } else if (!show) {
            return false;
        } else {
            ToastUtils.showToastShort(context, context.getString(R.string.date_error));
            return false;
        }
    }

    public static Bitmap createQRCodeBitmap(String content, int width, int height, String character_set, String error_correction_level, String margin, int color_black, int color_white) {
        WriterException e;
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        if (width >= 0) {
            if (height >= 0) {
                try {
                    Hashtable<EncodeHintType, String> hints = new Hashtable<>();
                    if (!TextUtils.isEmpty(character_set)) {
                        try {
                            hints.put(EncodeHintType.CHARACTER_SET, character_set);
                        } catch (WriterException e2) {
                            e = e2;
                            e.printStackTrace();
                            return null;
                        }
                    }
                    if (!TextUtils.isEmpty(error_correction_level)) {
                        try {
                            hints.put(EncodeHintType.ERROR_CORRECTION, error_correction_level);
                        } catch (WriterException e3) {
                            e = e3;
                            e.printStackTrace();
                            return null;
                        }
                    }
                    if (!TextUtils.isEmpty(margin)) {
                        try {
                            hints.put(EncodeHintType.MARGIN, margin);
                        } catch (WriterException e4) {
                            e = e4;
                            e.printStackTrace();
                            return null;
                        }
                    }
                    BitMatrix bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
                    int[] pixels = new int[(width * height)];
                    for (int y = 0; y < height; y++) {
                        for (int x = 0; x < width; x++) {
                            if (bitMatrix.get(x, y)) {
                                pixels[(y * width) + x] = color_black;
                            } else {
                                pixels[(y * width) + x] = color_white;
                            }
                        }
                    }
                    Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
                    return bitmap;
                } catch (WriterException e5) {
                    e = e5;
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    public static void saveBitmap(String name, Bitmap bitmap, Context context) {
        File saveFile = new File("/mnt/vendor/persist/OEM", name);
        try {
            FileOutputStream saveImgOut = new FileOutputStream(saveFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, saveImgOut);
            saveImgOut.flush();
            saveImgOut.close();
            Log.d("saveBitmap", saveFile.getPath());
        } catch (IOException e) {
        }
    }
}