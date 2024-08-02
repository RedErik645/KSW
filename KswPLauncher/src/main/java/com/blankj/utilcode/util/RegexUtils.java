package com.blankj.utilcode.util;

import android.arch.persistence.room.RoomMasterTable;
import android.support.v4.util.SimpleArrayMap;
import com.blankj.utilcode.constant.RegexConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {
    private static final SimpleArrayMap<String, String> CITY_MAP = new SimpleArrayMap<>();

    private RegexUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isMobileSimple(CharSequence input) {
        return isMatch(RegexConstants.REGEX_MOBILE_SIMPLE, input);
    }

    public static boolean isMobileExact(CharSequence input) {
        return isMobileExact(input, null);
    }

    public static boolean isMobileExact(CharSequence input, List<String> newSegments) {
        if (isMatch(RegexConstants.REGEX_MOBILE_EXACT, input)) {
            return true;
        }
        if (newSegments == null || input == null || input.length() != 11) {
            return false;
        }
        String content = input.toString();
        for (char c : content.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        for (String newSegment : newSegments) {
            if (content.startsWith(newSegment)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTel(CharSequence input) {
        return isMatch(RegexConstants.REGEX_TEL, input);
    }

    public static boolean isIDCard15(CharSequence input) {
        return isMatch(RegexConstants.REGEX_ID_CARD15, input);
    }

    public static boolean isIDCard18(CharSequence input) {
        return isMatch(RegexConstants.REGEX_ID_CARD18, input);
    }

    /* JADX INFO: Multiple debug info for r5v6 int: [D('idCardMod' int), D('i' int)] */
    public static boolean isIDCard18Exact(CharSequence input) {
        if (isIDCard18(input)) {
            int[] factor = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            char[] suffix = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
            SimpleArrayMap<String, String> simpleArrayMap = CITY_MAP;
            if (simpleArrayMap.isEmpty()) {
                simpleArrayMap.put("11", "北京");
                simpleArrayMap.put("12", "天津");
                simpleArrayMap.put("13", "河北");
                simpleArrayMap.put("14", "山西");
                simpleArrayMap.put("15", "内蒙古");
                simpleArrayMap.put("21", "辽宁");
                simpleArrayMap.put("22", "吉林");
                simpleArrayMap.put("23", "黑龙江");
                simpleArrayMap.put("31", "上海");
                simpleArrayMap.put("32", "江苏");
                simpleArrayMap.put("33", "浙江");
                simpleArrayMap.put("34", "安徽");
                simpleArrayMap.put("35", "福建");
                simpleArrayMap.put("36", "江西");
                simpleArrayMap.put("37", "山东");
                simpleArrayMap.put("41", "河南");
                simpleArrayMap.put(RoomMasterTable.DEFAULT_ID, "湖北");
                simpleArrayMap.put("43", "湖南");
                simpleArrayMap.put("44", "广东");
                simpleArrayMap.put("45", "广西");
                simpleArrayMap.put("46", "海南");
                simpleArrayMap.put("50", "重庆");
                simpleArrayMap.put("51", "四川");
                simpleArrayMap.put("52", "贵州");
                simpleArrayMap.put("53", "云南");
                simpleArrayMap.put("54", "西藏");
                simpleArrayMap.put("61", "陕西");
                simpleArrayMap.put("62", "甘肃");
                simpleArrayMap.put("63", "青海");
                simpleArrayMap.put("64", "宁夏");
                simpleArrayMap.put("65", "新疆");
                simpleArrayMap.put("71", "台湾");
                simpleArrayMap.put("81", "香港");
                simpleArrayMap.put("82", "澳门");
                simpleArrayMap.put("91", "国外");
            }
            if (simpleArrayMap.get(input.subSequence(0, 2).toString()) != null) {
                int weightSum = 0;
                for (int i = 0; i < 17; i++) {
                    weightSum += (input.charAt(i) - '0') * factor[i];
                }
                if (input.charAt(17) == suffix[weightSum % 11]) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean isEmail(CharSequence input) {
        return isMatch(RegexConstants.REGEX_EMAIL, input);
    }

    public static boolean isURL(CharSequence input) {
        return isMatch(RegexConstants.REGEX_URL, input);
    }

    public static boolean isZh(CharSequence input) {
        return isMatch(RegexConstants.REGEX_ZH, input);
    }

    public static boolean isUsername(CharSequence input) {
        return isMatch(RegexConstants.REGEX_USERNAME, input);
    }

    public static boolean isDate(CharSequence input) {
        return isMatch(RegexConstants.REGEX_DATE, input);
    }

    public static boolean isIP(CharSequence input) {
        return isMatch(RegexConstants.REGEX_IP, input);
    }

    public static boolean isMatch(String regex, CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }

    public static List<String> getMatches(String regex, CharSequence input) {
        if (input == null) {
            return Collections.emptyList();
        }
        List<String> matches = new ArrayList<>();
        Matcher matcher = Pattern.compile(regex).matcher(input);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    public static String[] getSplits(String input, String regex) {
        if (input == null) {
            return new String[0];
        }
        return input.split(regex);
    }

    public static String getReplaceFirst(String input, String regex, String replacement) {
        if (input == null) {
            return "";
        }
        return Pattern.compile(regex).matcher(input).replaceFirst(replacement);
    }

    public static String getReplaceAll(String input, String regex, String replacement) {
        if (input == null) {
            return "";
        }
        return Pattern.compile(regex).matcher(input).replaceAll(replacement);
    }
}
