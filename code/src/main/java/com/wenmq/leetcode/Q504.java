package com.wenmq.leetcode;

/**
 * {https://leetcode-cn.com/problems/base-7/}
 */
public class Q504 {

    static class Solution {
        public String convertToBase7(int num) {
            if (num == 0) return "0";
            StringBuilder sb = new StringBuilder();
            boolean minus = num < 0;
            if (minus) {
                num = -num + 1;
            }
            while (num != 0) {
                sb.append(num % 7);
                num /= 7;
            }
            if (minus) {
                sb.append('-');
            }
            sb.reverse();
            return sb.toString();
        }
    }


}
