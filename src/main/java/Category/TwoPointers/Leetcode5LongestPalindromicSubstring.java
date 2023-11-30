package Category.TwoPointers;

import org.instancio.Instancio;

public class Leetcode5LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String max = "";

        for (int i = 0; i < s.length(); i++) {
            String s1 = findSingleMidPalindromeLength(s, i);
            String s2 = findDoubleMidPalindromeLength(s, i);
            String r = s1.length() > s2.length() ? s1 : s2;
            max = max.length() > r.length() ? max : r;
        }
        return max;
    }

    private static String findSingleMidPalindromeLength(String s, int index) {
        int length = 1;
        int i = 1;

        while (index - i >= 0 && index + i <= s.length() - 1 && s.charAt(index - i) == s.charAt(index + i)) {
            length += 2;
            i++;
        }
        i--;
        return length == 1 ? String.valueOf(s.charAt(index)) : s.substring(index - i, index + i + 1);
    }

    private static String findDoubleMidPalindromeLength(String s, int index) {
        int length = 0;
        int i = 0;

        int left = index;
        int right = index + 1;
        while (left - i >= 0 && right + i <= s.length() - 1 && s.charAt(left - i) == s.charAt(right + i)) {
            length += 2;
            i++;
        }
        i--;
        return s.substring(left - i, right + i + 1);
    }

    public static void main(String[] args) {
        String bb = Instancio.create(String.class);
        System.out.println("bb = " + bb);
        System.out.println(longestPalindrome(bb));

        String len1 = findSingleMidPalindromeLength(bb, 1);
        System.out.println(len1);

        String len2 = findDoubleMidPalindromeLength(bb, 0);
        System.out.println(len2);
    }
}
