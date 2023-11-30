package Easy;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class No20ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpenBracket(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                if (!isMatch(c, stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char c) {
        return switch (c) {
            case '(', '{', '[' -> true;
            default -> false;
        };
    }

    private static boolean isMatch(char c, char compareChar) {
        return switch (c) {
            case ')':
                yield compareChar == '(';
            case '}':
                yield compareChar == '{';
            case ']':
                yield compareChar == '[';
            default:
                yield false;
        };
    }

    public static void main(String[] args) {
       assert  isValid("()[]{}");
    }
}
