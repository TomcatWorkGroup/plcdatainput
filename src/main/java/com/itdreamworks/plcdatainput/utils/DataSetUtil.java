package com.itdreamworks.plcdatainput.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;

public class DataSetUtil {
    private DataSetUtil() {

    }

    private HashSet<Object> set;

    public static DataSetUtil getInstance() {
        DataSetUtil util = new DataSetUtil();
        util.set = new HashSet<>(10000);
        return util;
    }

    public void putCache(JSONArray jsonArray) {
        for (Object object : jsonArray) {
            JSONObject jsonObject = JSONObject.parseObject(object.toString());
            set.add(jsonObject.get("deviceSuffix"));
        }
        DataSet.setSet(set);
    }

    public static HashSet<Object> getSet() {
        return DataSet.getSet();
    }
}
