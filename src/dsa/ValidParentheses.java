package dsa;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> charsToBeProcessed = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '[')
                charsToBeProcessed.push(currentChar);
            else if (charsToBeProcessed.isEmpty())
                return false;
            else {
                Character charAtTopOfStack = charsToBeProcessed.peek();
                if ((charAtTopOfStack == '(' && currentChar != ')')
                    || (charAtTopOfStack == '{' && currentChar != '}')
                    || (charAtTopOfStack == '[' && currentChar != ']'))
                    return false;
                charsToBeProcessed.pop();
            }
        }
        return charsToBeProcessed.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("({})"));
    }
}
