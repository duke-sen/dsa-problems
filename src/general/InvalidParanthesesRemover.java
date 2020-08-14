package general;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * problem link : https://leetcode.com/problems/remove-invalid-parentheses/
 * Source repo : https://github.com/arkadev-gh/dsa-problems/blob/master/src/main/java/com/leetcode/algorithms/minRemoveParen/MinRemoveParentheses.javas
 */
public class InvalidParanthesesRemover {

    private String removeInvalidParantheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        boolean[] indices = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (currentCharacter == ')') {
                if (stack.isEmpty() || s.charAt(stack.peek()) != '(') {
                    stack.push(i);
                }
                else {
                    stack.pop();
                }
            }
            else {
                stack.push(i);
            }
        }

        for (Integer itr : stack)
            indices[itr] = true;

        for (int i = 0; i < indices.length; i++) {
            if (!indices[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "))((()";
        InvalidParanthesesRemover paranthesesRemover = new InvalidParanthesesRemover();
        System.out.println(paranthesesRemover.removeInvalidParantheses(str));
    }
}
