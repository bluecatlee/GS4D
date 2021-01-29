//package com.github.bluecatlee.gs4d.sequence.utils;
//
//public class I {
//    public static final String aE = "";
//
//    public static final int aF = -1;
//
//    private static final int aG = 8192;
//
//    private static String a(int paramInt, char paramChar) throws IndexOutOfBoundsException {
//        if (paramInt < 0)
//            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + paramInt);
//        char[] arrayOfChar = new char[paramInt];
//        for (byte b = 0; b < arrayOfChar.length; b++)
//            arrayOfChar[b] = paramChar;
//        return new String(arrayOfChar);
//    }
//
//    public static String a(String paramString, int paramInt) {
//        return a(paramString, paramInt, ' ');
//    }
//
//    public static String a(String paramString, int paramInt, char paramChar) {
//        if (paramString == null)
//            return null;
//        int j = paramInt - paramString.length();
//        if (j <= 0)
//            return paramString;
//        if (j > 8192)
//            return a(paramString, paramInt, String.valueOf(paramChar));
//        return paramString.concat(a(j, paramChar));
//    }
//
//    public static String a(String paramString1, int paramInt, String paramString2) {
//        if (paramString1 == null)
//            return null;
//        if (isEmpty(paramString2))
//            paramString2 = " ";
//        int j = paramString2.length();
//        int k = paramString1.length();
//        int m = paramInt - k;
//        if (m <= 0)
//            return paramString1;
//        if (j == 1 && m <= 8192)
//            return a(paramString1, paramInt, paramString2.charAt(0));
//        if (m == j)
//            return paramString1.concat(paramString2);
//        if (m < j)
//            return paramString1.concat(paramString2.substring(0, m));
//        char[] arrayOfChar1 = new char[m];
//        char[] arrayOfChar2 = paramString2.toCharArray();
//        for (byte b = 0; b < m; b++)
//            arrayOfChar1[b] = arrayOfChar2[b % j];
//        return paramString1.concat(new String(arrayOfChar1));
//    }
//
//    public static String b(String paramString, int paramInt) {
//        return b(paramString, paramInt, ' ');
//    }
//
//    public static String b(String paramString, int paramInt, char paramChar) {
//        if (paramString == null)
//            return null;
//        int j = paramInt - paramString.length();
//        if (j <= 0)
//            return paramString;
//        if (j > 8192)
//            return b(paramString, paramInt, String.valueOf(paramChar));
//        return a(j, paramChar).concat(paramString);
//    }
//
//    public static String b(String paramString1, int paramInt, String paramString2) {
//        if (paramString1 == null)
//            return null;
//        if (isEmpty(paramString2))
//            paramString2 = " ";
//        int j = paramString2.length();
//        int k = paramString1.length();
//        int m = paramInt - k;
//        if (m <= 0)
//            return paramString1;
//        if (j == 1 && m <= 8192)
//            return b(paramString1, paramInt, paramString2.charAt(0));
//        if (m == j)
//            return paramString2.concat(paramString1);
//        if (m < j)
//            return paramString2.substring(0, m).concat(paramString1);
//        char[] arrayOfChar1 = new char[m];
//        char[] arrayOfChar2 = paramString2.toCharArray();
//        for (byte b = 0; b < m; b++)
//            arrayOfChar1[b] = arrayOfChar2[b % j];
//        return (new String(arrayOfChar1)).concat(paramString1);
//    }
//
//    public static int m(String paramString) {
//        return (paramString == null) ? 0 : paramString.length();
//    }
//
//    public static boolean isEmpty(String paramString) {
//        return (paramString == null || paramString.length() == 0);
//    }
//
//    public static String frontCompWithZore(Long paramLong, int paramInt) {
//        return String.format("%0" + paramInt + "d", new Object[] { paramLong });
//    }
//}
