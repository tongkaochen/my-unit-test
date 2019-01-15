package com.demo.tifone.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;

public class StringUtilTest {

    @Test
    public void testIsStringVerify1() {
        assertFalse(StringUtil.isValidString(""));
        assertTrue(StringUtil.isValidString("12345678"));
        String str32 = "";
        for (int i = 0; i < 30; i++) {
            str32 = str32 + (i + 1);
        }
        assertFalse(StringUtil.isValidString(str32));
    }

    @Test
    public void testIsStringVerify2() {
        assertFalse(StringUtil.isValidString(null, 0));
        assertFalse(StringUtil.isValidString("", 1));
        assertTrue(StringUtil.isValidString("12345678", 7));
        String str32 = "";
        for (int i = 0; i < 30; i++) {
            str32 = str32 + (i + 1);
        }
        assertFalse(StringUtil.isValidString(str32, 20));
    }

    @Test
    public void testIsStringVerify3() {
        assertFalse(StringUtil.isValidString(null, 0, 0));
        assertFalse(StringUtil.isValidString("", 1, 20));
        assertTrue(StringUtil.isValidString("12345678", 7, 10));
        String str32 = "";
        for (int i = 0; i < 30; i++) {
            str32 = str32 + (i + 1);
        }
        System.out.print(str32.length());
        assertTrue(StringUtil.isValidString(str32, 20, 100));
    }

    @Test
    public void testBulletedFormat() {
        String src = "^ This is to verify that the bulleted format works without any issues." +
                "Set the PreDownloadMessage field as follows: This is a test paragraph #1 in the PreDownloadMessage field.&#13;This is test paragraph#2 in the PreDownloadMessage field.^Bulleted Item #1^Bulleted Item#2^Bulleted Item #3^^This is paragraph#3 in the PreDownloadMessage field.&#13;This is paragraph#4 in the PreDownloadMessage field.^Bulleted Item #4^Bulleted Item$#5";
        String expected = "&bull; This is to verify that the bulleted format works without any issues." +
                "Set the PreDownloadMessage field as follows: This is a test paragraph #1 in the PreDownloadMessage field.&lt;br&gt;This is test paragraph#2 in the PreDownloadMessage field.&lt;br&gt;&bull;Bulleted Item #1&lt;br&gt;&bull;Bulleted Item#2&lt;br&gt;&bull;Bulleted Item #3&lt;br&gt;&lt;br&gt;This is paragraph#3 in the PreDownloadMessage field.&lt;br&gt;This is paragraph#4 in the PreDownloadMessage field.&lt;br&gt;&bull;Bulleted Item #4&lt;br&gt;&bull;Bulleted Item$#5";
        String result = StringUtil.formatBulletString(src);
        assertThat(result, is(expected));
    }

    @Test
    public void testHardwareVersion() {
        String broadInfo = "PROTO_TEST_BOARD";
        String hardware = StringUtil.getHardwareVersion(broadInfo);
        assertThat(hardware, is("02"));
        broadInfo = "MOCKUP_TEST_BOARD";
        hardware = StringUtil.getHardwareVersion(broadInfo);
        assertThat(hardware, is("01"));
        broadInfo = "PIO_TEST_BOARD";
        hardware = StringUtil.getHardwareVersion(broadInfo);
        assertThat(hardware, is("03"));
    }
}