package com.teach.datalibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 任小龙 on 2020/10/28.
 */
public class ThirdLoginInfo implements Parcelable {
    public int type;
    public String openid;
    public String access_token;
    public String refresh_token;
    private long expires_in;
    public String unionid;

    public String pay_token;
    public int proxy_expires_in;
    public String pf;
    public String pfkey;
    public int login_cost;
    public int query_authority_cost;
    public int authority_cost;
    public long expires_time;

    protected ThirdLoginInfo(Parcel in) {
        type = in.readInt();
        openid = in.readString();
        access_token = in.readString();
        refresh_token = in.readString();
        expires_in = in.readLong();
        unionid = in.readString();
        pay_token = in.readString();
        proxy_expires_in = in.readInt();
        pf = in.readString();
        pfkey = in.readString();
        login_cost = in.readInt();
        query_authority_cost = in.readInt();
        authority_cost = in.readInt();
        expires_time = in.readLong();
    }

    public static final Creator<ThirdLoginInfo> CREATOR = new Creator<ThirdLoginInfo>() {
        @Override
        public ThirdLoginInfo createFromParcel(Parcel in) {
            return new ThirdLoginInfo(in);
        }

        @Override
        public ThirdLoginInfo[] newArray(int size) {
            return new ThirdLoginInfo[size];
        }
    };

    public long getExpires_in() {
        return expires_in / 1000;
    }

    public void setExpires_in(long pExpires_in) {
        expires_in = pExpires_in;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeString(openid);
        dest.writeString(access_token);
        dest.writeString(refresh_token);
        dest.writeLong(expires_in);
        dest.writeString(unionid);
        dest.writeString(pay_token);
        dest.writeInt(proxy_expires_in);
        dest.writeString(pf);
        dest.writeString(pfkey);
        dest.writeInt(login_cost);
        dest.writeInt(query_authority_cost);
        dest.writeInt(authority_cost);
        dest.writeLong(expires_time);
    }
}
