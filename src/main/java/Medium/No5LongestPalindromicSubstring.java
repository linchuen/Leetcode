package Medium;

public class No5LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int maxPalindrome = 0;
        String longestPalindrome = String.valueOf(s.charAt(0));
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                boolean isPalindrome = isPalindromeString(chars, i, j);
                if (!isPalindrome) continue;

                int length = j - i + 1;
                if (length > maxPalindrome) {
                    maxPalindrome = length;
                    longestPalindrome = s.substring(i, j + 1);
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
            if (startChar == endChar) {
                start++;
                end--;
            } else {
                return false;
            }
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
