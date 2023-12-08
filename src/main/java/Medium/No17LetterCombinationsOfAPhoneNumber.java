package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class No17LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        if (digits.isBlank()) return Collections.emptyList();

        Map<Character, List<String>> digitLetterMap = Map.of(
                '2', List.of("a", "b", "c"),
                '3', List.of("d", "e", "f"),
                '4', List.of("g", "h", "i"),
                '5', List.of("j", "k", "l"),
                '6', List.of("m", "n", "o"),
                '7', List.of("p", "q", "r", "s"),
                '8', List.of("t", "u", "v"),
                '9', List.of("w", "x", "y", "z")
        );
        List<String> result = null;
        for (char digit : digits.toCharArray()) {
            if (result == null) {
                result = digitLetterMap.get(digit);
            } else {
                result = combineLetter(result, digitLetterMap.get(digit));
            }
        }
        return result;
    }

    private static List<String> combineLetter(List<String> baseLetters, List<String> addedLetters) {
        List<String> result = new ArrayList<>();
        for (String baseLetter : baseLetters) {
            for (String addedLetter : addedLetters) {
                result.add(baseLetter + addedLetter);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        letterCombinations(digits).forEach(System.out::println);
    }
}
