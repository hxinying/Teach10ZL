package com.teach.datalibrary;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by 任小龙 on 2020/10/24.
 */
public class ExamInfo implements Parcelable {
    public boolean success;
    public List<DataInnerInfo> data;

    protected ExamInfo(Parcel in) {
        success = in.readByte() != 0;
        data = in.createTypedArrayList(DataInnerInfo.CREATOR);
    }

    public static final Creator<ExamInfo> CREATOR = new Creator<ExamInfo>() {
        @Override
        public ExamInfo createFromParcel(Parcel in) {
            return new ExamInfo(in);
        }

        @Override
        public ExamInfo[] newArray(int size) {
            return new ExamInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success ? 1 : 0));
        dest.writeTypedList(data);
    }

    public static class DataInnerInfo implements Parcelable {
        public String name;
        public List<ListInnerInfo> albums;

        protected DataInnerInfo(Parcel in) {
            name = in.readString();
            albums = in.createTypedArrayList(ListInnerInfo.CREATOR);
        }

        public static final Creator<DataInnerInfo> CREATOR = new Creator<DataInnerInfo>() {
            @Override
            public DataInnerInfo createFromParcel(Parcel in) {
                return new DataInnerInfo(in);
            }

            @Override
            public DataInnerInfo[] newArray(int size) {
                return new DataInnerInfo[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeTypedList(albums);
        }
    }

    public static class ListInnerInfo implements Parcelable {
        public String image_url;
        public String image_ver;
        public String name;
        public String description;
        public String video_count;

        protected ListInnerInfo(Parcel in) {
            image_url = in.readString();
            image_ver = in.readString();
            name = in.readString();
            description = in.readString();
            video_count = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(image_url);
            dest.writeString(image_ver);
            dest.writeString(name);
            dest.writeString(description);
            dest.writeString(video_count);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<ListInnerInfo> CREATOR = new Creator<ListInnerInfo>() {
            @Override
            public ListInnerInfo createFromParcel(Parcel in) {
                return new ListInnerInfo(in);
            }

            @Override
            public ListInnerInfo[] newArray(int size) {
                return new ListInnerInfo[size];
            }
        };
    }
}
