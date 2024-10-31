package com.example.iosdialogdemo;


import com.google.gson.annotations.SerializedName;

public class Shop {
    /**
     * position : 772024102801
     * name : 大润发超市
     * icon : http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg
     * phone : 13952141236
     * address : 成都市双流区华阳时代广场a栋701室
     */

    @SerializedName("position")
    public String position;
    @SerializedName("name")
    public String name;
    @SerializedName("icon")
    public String icon;
    @SerializedName("phone")
    public String phone;
    @SerializedName("address")
    public String address;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
