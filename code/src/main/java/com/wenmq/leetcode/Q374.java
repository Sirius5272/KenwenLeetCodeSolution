package com.wenmq.leetcode;

/**
 * Q374
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 */
public class Q374 {

    static class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left < right) {
                while (left < right && notVowels(chars[left])) {
                    left++;
                }
                while (left < right && notVowels(chars[right])) {
                    right--;
                }
                if (left >= right) break;
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            return new String(chars);

        }

        boolean notVowels(char character) {
            switch (character) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    return false;
                default:
                    return true;
            }
        }

    }

    public static void main(String[] args) {
        Solution solution  = new Solution();
        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leetcode"));
    }


}
