package com.teach.datalibrary;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 任小龙 on 2020/11/17.
 */
public class MatchData implements Serializable {
    protected MatchData(){}
    private static final long serialVersionUID = -6017201948300325188L;
    public String date;
    public String index;
    public List<Data> data;

    public static class Data{
        public String time;
        public List<ItemData> itemData;

        public static class ItemData{
            public String id;
            public String leftName;
            public String leftIcon;
            public String rightName;
            public String rightIcon;
            public String category;
            public String categoryShort;
            public String position;
            public String leftScore;
            public String rightScore;
            public String playbackUrl;
            public String videoId;
            public String typeName;
            public String title;
            public String time;
            public String servertime;
            public String isSubscribe;
            public String status;
            public String isHot;
            public String isVip;
            public String type;
            public String scheduleIcon;
            public String narrateDesc;
            public String ordernum;
            public String date;
            public String md;
            public String week;
            public String timeDesc;
            public String liveType;
            public List<Anchors> anchors;
            public List<SourceList> sourceList;
            public class Anchors{
                public String uid;
                public String uname;
                public String uemail;
                public String usname;
                public String uhimgb;
                public String uhimg;
                public String urtitle;
                public String urlogo;
                public String rvnum;
                public String uhlevel;
                public String roomid;
                public String userfrom;
                public String follownum;
                public String mobile;
                public String bomoney;
                public String bobeans;
                public String roomNotice;
                public String sourceImg;
                public String pendant;
                public String commentaryTag;
                public String isVip;
                public String isLive;
                public String isHost;
                public String authInfo;
            }
            public class SourceList{

            }
        }
    }
}
