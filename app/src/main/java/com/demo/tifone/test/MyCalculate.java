package com.demo.tifone.test;

class MyCalculate {
    public int add(int value1, int value2) {
        return value1 + value2;
    }

    public String add(String str1, String str2) {
        StringBuffer builder = new StringBuffer();
        builder.append(str1);
        builder.append(str2);
        return builder.toString();
    }
}
