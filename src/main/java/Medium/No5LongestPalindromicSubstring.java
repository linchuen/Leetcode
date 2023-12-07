package Medium;

public class No5LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int maxPalindrome = 0;
        String longestPalindrome = String.valueOf(s.charAt(0));
        char[] chars = s.toCharArray();
        for (int left = 0; left < s.length(); left++) {
            for (int right = s.length() - 1; right > left; right--) {
                boolean isPalindrome = isPalindromeString(chars, left, right);
                if (!isPalindrome) continue;

                int length = right - left + 1;
                if (length > maxPalindrome) {
                    maxPalindrome = length;
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
