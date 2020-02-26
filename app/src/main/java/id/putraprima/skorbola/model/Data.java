package id.putraprima.skorbola.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.security.PrivateKey;

public class Data implements Parcelable {
    private Bitmap awaylogo;
    private Bitmap homelogo;
    private String awayteam;
    private String hometeam;
    private String awayscore;
    private String homescore;
    //private  String result;


    public String getAwayscore() {
        return awayscore;
    }

    public void setAwayscore(String awayscore) {
        this.awayscore = awayscore;
    }

    public String getHomescore() {
        return homescore;
    }

    public void setHomescore(String homescore) {
        this.homescore = homescore;
    }

    public Data(Bitmap awaylogo, Bitmap homelogo, String awayteam, String hometeam) {
        this.awaylogo = awaylogo;
        this.homelogo = homelogo;
        this.awayteam = awayteam;
        this.hometeam = hometeam;
    }

    public Data(String awayteam, String hometeam) {
        this.awayteam = awayteam;
        this.hometeam = hometeam;
    }

    public Bitmap getAwaylogo() {
        return awaylogo;
    }

    public void setAwaylogo(Bitmap awaylogo) {
        this.awaylogo = awaylogo;
    }

    public Bitmap getHomelogo() {
        return homelogo;
    }

    public void setHomelogo(Bitmap homelogo) {
        this.homelogo = homelogo;
    }

    public String getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(String awayteam) {
        this.awayteam = awayteam;
    }

    public String getHometeam() {
        return hometeam;
    }

    public void setHometeam(String hometeam) {
        this.hometeam = hometeam;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(awaylogo, flags);
        dest.writeParcelable(homelogo, flags);
        dest.writeString(awayteam);
        dest.writeString(hometeam);
    }


    protected Data(Parcel in) {
        awaylogo = in.readParcelable(Bitmap.class.getClassLoader());
        homelogo = in.readParcelable(Bitmap.class.getClassLoader());
        awayteam = in.readString();
        hometeam = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
