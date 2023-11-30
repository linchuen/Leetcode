package Easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 */
public class No14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longestCommonPrefix = getCommonPrefix(longestCommonPrefix, strs[i]);
            if (longestCommonPrefix.isBlank()) break;
        }
        return longestCommonPrefix;
    }

    private String getCommonPrefix(String str1, String str2) {
        int size = Math.min(str1.length(), str2.length());

        for (int i = 0; i < size; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
            ;
        }
        return str1.substring(0, size);
    }

    public static void main(String[] args) {
        No14LongestCommonPrefix no14LongestCommonPrefix = new No14LongestCommonPrefix();
        String[] strs = new String[]{"flower", "flow", "flight"};
        String result = no14LongestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(result);
        assert result.equals("fl");
    }
}
