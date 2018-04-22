package com.diegomalone.amarotest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Product implements Parcelable {

    @SerializedName("name")
    private String name;

    @SerializedName("style")
    private String style;

    @SerializedName("code_color")
    private String colorCode;

    @SerializedName("color_slug")
    private String colorSlug;

    @SerializedName("color")
    private String color;

    @SerializedName("on_sale")
    private Boolean onSale;

    @SerializedName("regular_price")
    private String regularPrice;

    @SerializedName("actual_price")
    private String actualPrice;

    @SerializedName("discount_percentage")
    private String discountPercentage;

    @SerializedName("installments")
    private String installments;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("sizes")
    private List<Size> sizeList;

    public Product(String name, String style, String colorCode, String colorSlug, String color,
                   Boolean onSale, String regularPrice, String actualPrice, String discountPercentage,
                   String installments, String imageUrl, List<Size> sizeList) {
        this.name = name;
        this.style = style;
        this.colorCode = colorCode;
        this.colorSlug = colorSlug;
        this.color = color;
        this.onSale = onSale;
        this.regularPrice = regularPrice;
        this.actualPrice = actualPrice;
        this.discountPercentage = discountPercentage;
        this.installments = installments;
        this.imageUrl = imageUrl;
        this.sizeList = sizeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorSlug() {
        return colorSlug;
    }

    public void setColorSlug(String colorSlug) {
        this.colorSlug = colorSlug;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Size> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<Size> sizeList) {
        this.sizeList = sizeList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", colorCode='" + colorCode + '\'' +
                ", colorSlug='" + colorSlug + '\'' +
                ", color='" + color + '\'' +
                ", onSale=" + onSale +
                ", regularPrice='" + regularPrice + '\'' +
                ", actualPrice='" + actualPrice + '\'' +
                ", discountPercentage='" + discountPercentage + '\'' +
                ", installments='" + installments + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", sizeList=" + sizeList +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.style);
        dest.writeString(this.colorCode);
        dest.writeString(this.colorSlug);
        dest.writeString(this.color);
        dest.writeValue(this.onSale);
        dest.writeString(this.regularPrice);
        dest.writeString(this.actualPrice);
        dest.writeString(this.discountPercentage);
        dest.writeString(this.installments);
        dest.writeString(this.imageUrl);
        dest.writeList(this.sizeList);
    }

    protected Product(Parcel in) {
        this.name = in.readString();
        this.style = in.readString();
        this.colorCode = in.readString();
        this.colorSlug = in.readString();
        this.color = in.readString();
        this.onSale = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.regularPrice = in.readString();
        this.actualPrice = in.readString();
        this.discountPercentage = in.readString();
        this.installments = in.readString();
        this.imageUrl = in.readString();
        this.sizeList = new ArrayList<Size>();
        in.readList(this.sizeList, Size.class.getClassLoader());
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
