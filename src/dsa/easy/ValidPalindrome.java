package dsa.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] inputAsCharArray = s.toCharArray();
        int lowPtr = 0, highPtr = inputAsCharArray.length - 1;

        while (lowPtr <= highPtr) {

            if (checkIfCharactersAreEqual(inputAsCharArray[lowPtr], inputAsCharArray[highPtr])) {
                lowPtr++;
                highPtr--;
            }
            else if (!Character.isLetterOrDigit(inputAsCharArray[lowPtr]))
                lowPtr++;
            else if (!Character.isLetterOrDigit(inputAsCharArray[highPtr]))
                highPtr--;
            else return false;
        }
        return true;
    }

    private boolean checkIfCharactersAreEqual(char charOne, char charTwo) {
        if (charOne == charTwo)
            return true;
        return Character.toLowerCase(charOne) == Character.toLowerCase(charTwo);
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
