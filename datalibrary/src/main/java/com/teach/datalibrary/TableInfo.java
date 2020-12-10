package com.teach.datalibrary;

import java.util.List;

/**
 * Created by 任小龙 on 2020/11/1.
 */
public class TableInfo {
    public String province;
    public List<TableContent> tableList;

    public TableInfo(String pProvince, List<TableContent> pTableList) {
        province = pProvince;
        tableList = pTableList;
    }

    public static class TableContent{
        public String tabName;
        public double tabData;

        public TableContent(String pTabName, double pTabData) {
            tabName = pTabName;
            tabData = pTabData;
        }
    }
}
