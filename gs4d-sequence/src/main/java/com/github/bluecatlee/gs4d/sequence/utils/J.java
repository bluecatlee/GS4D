package com.github.bluecatlee.gs4d.sequence.utils;

public class J {
    public static String e(int paramInt) {
        String str = "?";
        for (byte b = 1; b < paramInt; b++)
            str = str + ",?";
        return "values(" + str + ")";
    }

    public static Boolean o(String paramString) {
        if (null != paramString && !"".equals(paramString))
            return Boolean.valueOf(true);
        return Boolean.valueOf(false);
    }

    public static String a(Object paramObject) {
        if (null != paramObject && !paramObject.equals("null"))
            return "" + paramObject;
        return "";
    }

    private static int e(String paramString1, String paramString2) {
        int i = paramString1.length();
        int k = paramString2.length();
        if (i == 0)
            return k;
        if (k == 0)
            return i;
        int[][] arrayOfInt = new int[i + 1][k + 1];
        byte b1;
        for (b1 = 0; b1 <= i; b1++)
            arrayOfInt[b1][0] = b1;
        byte b2;
        for (b2 = 0; b2 <= k; b2++)
            arrayOfInt[0][b2] = b2;
        for (b1 = 1; b1 <= i; b1++) {
            char c = paramString1.charAt(b1 - 1);
            for (b2 = 1; b2 <= k; b2++) {
                byte b;
                char c1 = paramString2.charAt(b2 - 1);
                if (c == c1) {
                    b = 0;
                } else {
                    b = 1;
                }
                arrayOfInt[b1][b2] = b(arrayOfInt[b1 - 1][b2] + 1, arrayOfInt[b1][b2 - 1] + 1, arrayOfInt[b1 - 1][b2 - 1] + b);
            }
        }
        return arrayOfInt[i][k];
    }

    private static int b(int paramInt1, int paramInt2, int paramInt3) {
        return ((paramInt1 = (paramInt1 < paramInt2) ? paramInt1 : paramInt2) < paramInt3) ? paramInt1 : paramInt3;
    }

    public static boolean a(Object paramObject1, Object paramObject2) {
        boolean bool = false;
        if (paramObject1 == null && paramObject2 == null) {
            bool = true;
        } else if (paramObject1 != null) {
            bool = paramObject1.equals(paramObject2);
        } else {
            bool = paramObject2.equals(paramObject1);
        }
        return bool;
    }
}

