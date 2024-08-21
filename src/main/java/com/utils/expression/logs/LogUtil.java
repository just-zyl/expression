package com.utils.expression.logs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日志
 *
 */
public class LogUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public static void info() {
        LogUtil.info("");
    }

    public static void info(String message) {
        // 17:41:47.423 [main] INFO
        LocalDateTime dateTime = LocalDateTime.now();
        String dateStr = FORMATTER.format(dateTime);
        System.out.println(dateStr + " INFO: " + message);
    }

    public static void info(String message, Object... data) {
        boolean dataEmpty = data == null || data.length <= 0;
        if (dataEmpty) {
            LogUtil.info(message);
        }
        char[] chars = message.toCharArray();
        int charsLength = chars.length;
        StringBuilder result = new StringBuilder();
        int dataIndex = 0;
        for (int i = 0; i < charsLength - 1; i++) {
            char c = chars[i];
            if (!dataEmpty && c == '{' && chars[i + 1] == '}') {
                result.append(data[dataIndex++]);
                i++;
                continue;
            }
            result.append(c);
        }
        LogUtil.info(result.toString());
    }
}
