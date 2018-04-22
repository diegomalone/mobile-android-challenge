package com.diegomalone.amarotest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Size implements Parcelable {

    @SerializedName("available")
    private Boolean available;

    @SerializedName("size")
    private String sizeText;

    @SerializedName("sku")
    private String sku;

    public Size(Boolean available, String sizeText, String sku) {
        this.available = available;
        this.sizeText = sizeText;
        this.sku = sku;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getSizeText() {
        return sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Size{" +
                "available=" + available +
                ", sizeText='" + sizeText + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.available);
        dest.writeString(this.sizeText);
        dest.writeString(this.sku);
    }

    protected Size(Parcel in) {
        this.available = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.sizeText = in.readString();
        this.sku = in.readString();
    }

    public static final Parcelable.Creator<Size> CREATOR = new Parcelable.Creator<Size>() {
        @Override
        public Size createFromParcel(Parcel source) {
            return new Size(source);
        }

        @Override
        public Size[] newArray(int size) {
            return new Size[size];
        }
    };
}
