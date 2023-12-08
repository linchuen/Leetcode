package Medium;

/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class No5LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int maxLength = 0;
        String longestPalindrome = String.valueOf(s.charAt(0));
        char[] chars = s.toCharArray();
        for (int left = 0; left < s.length(); left++) {
            for (int right = s.length() - 1; right > left; right--) {
                int length = right - left + 1;
                if (maxLength > length) break;

                boolean isPalindrome = isPalindromeString(chars, left, right);
                if (!isPalindrome) continue;

                if (length > maxLength) {
                    maxLength = length;
                    longestPalindrome = s.substring(left, right + 1);
                }
                break;
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindromeString(char[] chars, int start, int end) {
        while (start < end) {
            char startChar = chars[start];
            char endChar = chars[end];
            if (startChar != endChar) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isPalindrome = isPalindromeString("abcba".toCharArray(), 0, 4);
        System.out.println(isPalindrome);
        assert isPalindrome;

        String result = longestPalindrome("asdasdfghjrjhgfdsaasd");
        System.out.println(result);

        System.out.println(isPalindromeString("aaaa".toCharArray(), 0, 3));
        System.out.println(longestPalindrome("aaaa"));
    }
}
