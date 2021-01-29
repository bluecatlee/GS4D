package com.github.bluecatlee.gs4d.sequence.utils;

public class ZkAddressUtil {
    public static final Integer updateTimeSche = 21600000;  // 21600s =  6h
    public static final Integer deletePassData = 600000;
    public static final String datePath = "/seqNode/currentDayDate";
    public static final String seqRootPath = "/seqNode";
    public static final String ZKSTATEERROR = "ERROE";
    public static final String ZKSTATENORMAL = "NORMAL";
    public static String ZKVERSION = "v7.0";

    public ZkAddressUtil() {
    }
}
