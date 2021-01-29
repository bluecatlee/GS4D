package com.github.bluecatlee.gs4d.sequence.utils;

import com.github.bluecatlee.gs4d.sequence.exception.SequenceException;
import com.github.bluecatlee.gs4d.sequence.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 序列号工具类
 */
public class SeqGetUtil {

    private static SubIdGetService sgs = new SubIdGetService();
    private static SubSequenceService sg = new SubSequenceService();
    private static SequenceService ss = new SequenceService();
    private static IniteZkConfigService izfs = new IniteZkConfigService();
    private static SequenceCliActionService sc = new SequenceCliActionService();

    public SeqGetUtil() {
    }

    /**
     * 初始化zookeeper配置
     * @param zkaddress
     */
    public static void initeZkConfig(String zkaddress) {
        izfs.initZkConfig(zkaddress);
    }

    public static Long getNoSubSequence(String systemName, String SeqName) {
        return ss.getNoSubSequence(systemName, SeqName);
    }

    public static List<Object> getNoSubSequenceBath(String systemName, String SeqName, Integer size) {
        return ss.getNoSubSequenceBath(systemName, SeqName, size);
    }

    public static String getSequence(String systemName, String SeqName, String routeId) {
        return sg.getSequence(systemName, SeqName, routeId);
    }

    public static List<String> getSequenceBatch(String systemName, String SeqName, String routeId, Integer size) {
        return sg.getSequenceBatch(systemName, SeqName, routeId, size);
    }

    public static String getMemberSequence(String systemName) {
        return String.valueOf(ss.getNoSubSequence(systemName, "ex_arc_consumer_user_usernumid"));
    }

    public static Long getSubIdBySeq(String seq) {
        return sgs.getSubIdBySeq(seq);
    }

    public static Long getThirdOrderHdrSequenceByDate(String systemName, String seqName, String date) {
        String oldSeq = String.valueOf(ss.getNoSubSequence(systemName, seqName));
        String newDate = buildDate(date);
        String newSeq = newDate + oldSeq.substring(5, oldSeq.length());
        return Long.valueOf(newSeq);
    }

    public static String getTmlNumByDate(String systemName, String SeqName, String routeId, String date) {
        String sequence = sg.getSequence(systemName, SeqName, routeId);
        String newDate = buildDate(date);
        String newSeq = sequence.substring(0, 2) + newDate + sequence.substring(5, sequence.length());
        return newSeq;
    }

    private static String buildDate(String date) {
        Date dt = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dt = sdf.parse(date);
        } catch (ParseException var6) {
            throw new SequenceException("获取序列号时时间格式转换异常" + date);
        }

        Calendar cld = Calendar.getInstance();
        cld.setTime(dt);
        String year = String.valueOf(cld.get(1)).substring(2, 4);
        String month = String.valueOf(cld.get(2) + 1);
        if (month.length() == 1) {
            month = "0" + month;
        }

        String day = String.valueOf(cld.get(5));
        if (day.length() == 1) {
            day = "0" + day;
        }

        return year + month + day;
    }

    public static Integer getSharedId(String routerId) {
        return routerId.length() >= 3 ? Integer.valueOf(routerId.substring(routerId.length() - 3, routerId.length())) : Integer.valueOf(routerId);
    }

    public static Integer getSharedId(Long routerId) {
        return routerId.toString().length() >= 3 ? Integer.valueOf(routerId.toString().substring(routerId.toString().length() - 3, routerId.toString().length())) : Integer.valueOf(routerId.toString());
    }

    public static Long getNoDateSequence(String systemName, String SeqName) {
        return sg.getNoDateSequence(systemName, SeqName);
    }

    public static List<Object> getNoSubSequenceBath(String SeqName, Integer size) {
        String systemName = "";
        return ss.getNoSubSequenceBath(systemName, SeqName, size);
    }

    public static String getSequence(String SeqName, String routeId) {
        String systemName = "";
        return sg.getSequence(systemName, SeqName, routeId);
    }

    public static List<String> getSequenceBatch(String SeqName, String routeId, Integer size) {
        String systemName = "";
        return sg.getSequenceBatch(systemName, SeqName, routeId, size);
    }

    public static String getMemberSequence() {
        String systemName = "";
        return String.valueOf(ss.getNoSubSequence(systemName, "ex_arc_consumer_user_usernumid"));
    }

    public static Long getThirdOrderHdrSequenceByDate(String seqName, String date) {
        String systemName = "";
        String oldSeq = String.valueOf(ss.getNoSubSequence(systemName, seqName));
        String newDate = buildDate(date);
        String newSeq = newDate + oldSeq.substring(5, oldSeq.length());
        return Long.valueOf(newSeq);
    }

    public static String getTmlNumByDate(String SeqName, String routeId, String date) {
        String systemName = "";
        String sequence = sg.getSequence(systemName, SeqName, routeId);
        String newDate = buildDate(date);
        String newSeq = sequence.substring(0, 2) + newDate + sequence.substring(5, sequence.length());
        return newSeq;
    }

    public static Long getNoDateSequence(String SeqName) {
        String systemName = "";
        return sg.getNoDateSequence(systemName, SeqName);
    }

    public static Long getNoSubSequence(String SeqName) {
        String systemName = "";
        return sc.getSequence(systemName, SeqName);
    }

    public static String getAutomicSequence(String SeqName, Integer num, Long tenantNumId, Long dataSign) {
        return sc.getAutomicSequence(SeqName, num, tenantNumId, dataSign);
    }

    public static String getAutomicSequence(String SeqName, Long tenantNumId, Long dataSign) {
        return sc.getAutomicSequence(SeqName, 1, tenantNumId, dataSign);
    }

    public static String getAutomicSequenceNoTenAndData(String SeqName) {
        return sc.getAutomicSequence(SeqName, 1, 0L, 0L);
    }

    public static List<Map<String, Object>> getOfflineSeqInfo(Long subUnitNumId) {
        return sc.getOfflineSeqInfo(subUnitNumId);
    }
}

