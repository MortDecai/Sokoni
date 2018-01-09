package other;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by John on 4/29/2017.
 */

public class News implements Parcelable {

    public String heading;
    public String body;
    public String author;
    public String date;
    public int newsPhoto;

    public News(String heading, String body, String author, String date, int newsPhoto) {
        this.heading = heading;
        this.body = body;
        this.author = author;
        this.date = date;
        this.newsPhoto = newsPhoto;
    }

    public News(Parcel in){
        this.heading = in.readString();
        this.body = in.readString();
        this.author = in.readString();
        this.date = in.readString();
        this.newsPhoto = in.readInt();
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        public News createFromParcel(Parcel in) {
            return new News(in);
        }
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(heading);
        parcel.writeString(body);
        parcel.writeString(author);
        parcel.writeString(date);
        parcel.writeInt(newsPhoto);
    }
}
