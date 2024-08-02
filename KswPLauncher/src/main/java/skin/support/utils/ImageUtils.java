package skin.support.utils;

import android.media.ExifInterface;
import com.wits.ksw.launcher.utils.Constants;
import java.io.IOException;

public class ImageUtils {
    public static int getImageRotateAngle(String filePath) {
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            exif = null;
        }
        if (exif == null) {
            return 0;
        }
        switch (exif.getAttributeInt("Orientation", 0)) {
            case 3:
                return 180;
            case 6:
                return 90;
            case 8:
                return Constants.DEFAULT_START_ANGLE;
            default:
                return 0;
        }
    }
}
