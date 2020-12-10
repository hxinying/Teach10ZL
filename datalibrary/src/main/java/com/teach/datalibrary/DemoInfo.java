package com.teach.datalibrary;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 任小龙 on 2020/9/25.
 */
public class DemoInfo implements Serializable ,Parcelable{
    private static final long serialVersionUID = -2469705371439382714L;
    public String status;
    public String msg;
    public int code;
    public List<DemoInnerDataInfo> datas;

    public DemoInfo() {
    }

    protected DemoInfo(Parcel in) {
        status = in.readString();
        msg = in.readString();
        code = in.readInt();
        datas = in.createTypedArrayList(DemoInnerDataInfo.CREATOR);
    }

    public static final Creator<DemoInfo> CREATOR = new Creator<DemoInfo>() {
        @Override
        public DemoInfo createFromParcel(Parcel in) {
            return new DemoInfo(in);
        }

        @Override
        public DemoInfo[] newArray(int size) {
            return new DemoInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(msg);
        dest.writeInt(code);
        dest.writeTypedList(datas);
    }

    public static class DemoInnerDataInfo implements Serializable, Parcelable {
        public String thumbnail;
        public String title;
        public String author;
        public String id;

        public DemoInnerDataInfo() {
        }

        protected DemoInnerDataInfo(Parcel in) {
            thumbnail = in.readString();
            title = in.readString();
            author = in.readString();
            id = in.readString();
        }

        public static final Creator<DemoInnerDataInfo> CREATOR = new Creator<DemoInnerDataInfo>() {
            @Override
            public DemoInnerDataInfo createFromParcel(Parcel in) {
                return new DemoInnerDataInfo(in);
            }

            @Override
            public DemoInnerDataInfo[] newArray(int size) {
                return new DemoInnerDataInfo[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(thumbnail);
            dest.writeString(title);
            dest.writeString(author);
            dest.writeString(id);
        }
    }
}
