package com.itdreamworks.plcdatainput.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DataSet {
    private static HashSet<Object> set;
    static {
        set = new HashSet<>();
    }
    public DataSet(){

    }

    public static HashSet<Object> getSet() {
        return set;
    }

    public static void setSet(HashSet<Object> dataSet) {
        set = dataSet;
    }
}
