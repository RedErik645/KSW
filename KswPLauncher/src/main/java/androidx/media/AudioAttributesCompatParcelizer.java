package androidx.media;

import android.support.v4.media.AudioAttributesCompat;
import android.support.v4.media.AudioAttributesImpl;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel parcel) {
        AudioAttributesCompat obj = new AudioAttributesCompat();
        obj.mImpl = (AudioAttributesImpl) parcel.readVersionedParcelable(obj.mImpl, 1);
        return obj;
    }

    public static void write(AudioAttributesCompat obj, VersionedParcel parcel) {
        parcel.setSerializationFlags(false, false);
        parcel.writeVersionedParcelable(obj.mImpl, 1);
    }
}
