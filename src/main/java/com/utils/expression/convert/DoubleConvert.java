package com.utils.expression.convert;

import cn.hutool.core.util.NumberUtil;

/**
 * double转换器
 *
 */
public class DoubleConvert {

    public static boolean isNumber(Object obj) {
        if (obj instanceof Double) {
            return true;
        }
        if (obj instanceof Integer) {
            return true;
        }
        if (obj instanceof Long) {
            return true;
        }
        if (obj instanceof Float) {
            return true;
        }
        if (obj instanceof CharSequence) {
            String objStr = String.valueOf(obj);
            return NumberUtil.isNumber(objStr);
        }
        return false;
    }

    public static Double convert(Object obj) {
        if (obj instanceof Double) {
            return ((Double) obj);
        }
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj));
        }
        if (obj instanceof Long) {
            return Double.valueOf(((Long) obj));
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj));
        }
        if (obj instanceof CharSequence) {
            String objStr = String.valueOf(obj);
            if (NumberUtil.isNumber(objStr)) {
                return NumberUtil.parseDouble(objStr);
            }
        }
        return null;
    }
}
