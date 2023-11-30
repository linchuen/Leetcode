package Easy;

import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class No13RomanToInteger {
    public static int romanToInt(String s) {
        if (s.isBlank()) return 0;

        Map<Character, Integer> romanMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        char[] chars = s.toCharArray();
        Character firstChar = chars[0];
        int total = romanMap.get(firstChar);
        for (int i = 1; i < chars.length; i++) {
            Character currentChar =chars[i];
            int value = romanMap.get(currentChar);
            total += value;

            Character preChar = chars[i - 1];
            int preValue = romanMap.get(preChar);
            if (preValue < value) {
                total = total - preValue * 2;
            }
        }
        return total;
    }

    //羅馬數字由大排到小
    public int romanToIntV2(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;

    }

    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        assert result == 1994;
    }
}
