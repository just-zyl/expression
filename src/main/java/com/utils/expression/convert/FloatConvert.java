package com.utils.expression.convert;

import cn.hutool.core.util.NumberUtil;

/**
 * float转换器
 *
 */
public class FloatConvert {

    public static Float convert(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj);
        }
        if (obj instanceof Integer) {
            return Float.valueOf(((Integer) obj));
        }
        if (obj instanceof Long) {
            return Float.valueOf(((Long) obj));
        }
        if (obj instanceof Double) {
            return Float.valueOf(String.valueOf(obj));
        }
        if (obj instanceof CharSequence) {
            String objStr = String.valueOf(obj);
            if (NumberUtil.isNumber(objStr)) {
                return NumberUtil.parseFloat(objStr);
            }
        }
        return null;
    }
}
