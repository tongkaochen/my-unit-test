package com.demo.tifone.test;

public class StringUtil {
    private static final int MAX_NAME_LENGTH = 32;
    private static final int MAX_PSW_LENGTH = 32;
    private StringUtil(){}

    public static boolean isValidString(String target) {
        return isValidString(target, 1, MAX_NAME_LENGTH);
    }
    public static boolean isValidString(String target, int minLength) {
        return isValidString(target, minLength, MAX_PSW_LENGTH);
    }
    public static boolean isValidString(String target, int minLength, int maxLength) {
        return target != null
                && target.length() >= minLength
                && target.length() <= maxLength;
    }

    public static String formatBulletString(String source) {
        if (source != null && !source.isEmpty()) {
            if (source.startsWith("^")) {
                source = source.substring(1, source.length());
                source = "&bull;" + source;
            }
            source = source.replace(">", "&gt;")
                    .replace("<", "&lt;")
                    .replace("^^", "\n\n")
                    .replace("^", "\n&bull;")
                    .replace("&#13;", "\n")
                    .replace("\n", "&lt;br&gt;");
        }
        return source;
    }

    public static String getHardwareVersion(String hardwareValue) {
        String hardwareLabel = hardwareValue;
        if (hardwareValue.contains("MOCKUP")) {
            hardwareLabel = "01";
        } else if (hardwareValue.contains("PROTO")) {
            hardwareLabel = "02";
        } else if (hardwareValue.contains("PIO")) {
            hardwareLabel = "03";
        }
        return hardwareLabel;
    }
}
