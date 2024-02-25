package dsa.easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] lettersAndFrequencies = new int[26];

        for (char ele : s.toCharArray()) {
            int currentEleIdx = ele - 'a';
            lettersAndFrequencies[currentEleIdx]++;
        }

        for (char ele : t.toCharArray()) {
            int currentEleIdx = ele - 'a';
            lettersAndFrequencies[currentEleIdx]--;
        }

        for (int i : lettersAndFrequencies) {
            if (i != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String strOne = "anagram";
        String strTwo = "nagaramm";
        System.out.println(new ValidAnagram().isAnagram(strOne, strTwo));
    }
}
