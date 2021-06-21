package com.wenmq.cn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Q401
 * https://leetcode-cn.com/problems/binary-watch/
 */
public class Solution401 {
    /**
     * 0 <= turnedOn <= 10
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        readBinaryWatch(list, turnedOn, 12, 0);
        return list;
    }

    private void readBinaryWatch(List<String> list, int turnedOn, int length, int key) {
        if (length == 0) {
            if (turnedOn != 0) {
                return;
            }
            String s = readFromBinary(key);
            if (s != null) {
                list.add(s);
            }
            return;
        }
        readBinaryWatch(list, turnedOn, length - 1, (key << 1));
        readBinaryWatch(list, turnedOn - 1, length - 1, (key << 1) + 1);
    }

    public static String readFromBinary(int num) {
        int min = num & 0x3F;
        int hour = num >> 6;
        if (min > 59 || hour > 11) {
            return null;
        }
        return String.format(Locale.getDefault(), "%d:%02d", hour, min);
    }


    static class Solution {

        // 直接把二进制的问题转换为数组累加问题
        int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
        int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
        List<String> res = new ArrayList<>();

        public List<String> readBinaryWatch(int turnedOn) {
            // 方法二：采用回溯法
            backTrack(turnedOn, 0, 0, 0);
            return res;

        }

        // 回溯的参数：num(需要点亮的灯，初始为turnedOn),index(点亮的下标)
        // hour(小时数)minute(分钟数)
        public void backTrack(int num, int index, int hour, int minute) {
            // 剪枝操作
            if (hour > 11 || minute > 59) {
                return;
            }
            // 递归出口,当点亮到第0栈灯的时候，那么回溯所有数据
            if (num == 0) {
                // 进行字符串拼接
                StringBuilder sb = new StringBuilder();
                sb.append(hour).append(':');
                if (minute < 10) {
                    sb.append('0');
                }
                sb.append(minute);
                res.add(sb.toString());
                //记得return终止掉
                return;
            }
            // 这里是从下标开始递归遍历
            for (int i = index; i < 10; i++) {
                backTrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
            }
        }
    }


}