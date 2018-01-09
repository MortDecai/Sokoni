package other;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by John on 4/30/2017.
 */

public class Ads implements Parcelable {
        public String heading;
        public String price;
        public String location;
        public String time;
        public int adPhoto;

        public Ads(String heading, String price, String location, String time, int adPhoto) {
            this.heading = heading;
            this.price = price;
            this.location = location;
            this.time = time;
            this.adPhoto = adPhoto;
        }

        public Ads(Parcel in){
            heading = in.readString();
            price = in.readString();
            location = in.readString();
            time = in.readString();
            adPhoto = in.readInt();
        }


    public static final Parcelable.Creator<Ads> CREATOR = new Parcelable.Creator<Ads>() {
        public Ads createFromParcel(Parcel in) {
            return new Ads(in);
        }
        public Ads[] newArray(int size) {
            return new Ads[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(heading);
        parcel.writeString(price);
        parcel.writeString(location);
        parcel.writeString(time);
        parcel.writeInt(adPhoto);

    }
}
