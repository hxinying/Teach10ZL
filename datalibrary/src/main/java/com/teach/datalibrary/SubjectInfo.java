package com.teach.datalibrary;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 任小龙 on 2020/10/5.
 */
public class SubjectInfo implements Serializable {

    private static final long serialVersionUID = -2291711597882990076L;

    public String bigspecialty;
    public int is_classify;
    public String icon;
    public List<SubjectDataInfo> data;

    public static class SubjectDataInfo implements Serializable{
        private static final long serialVersionUID = 3182858594666789236L;
        public String specialty_id;
        public int fid;
        public String specialty_name;
    }
}
