package dsa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordDictionary = new HashSet<>(wordDict);

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String currentSubString = s.substring(j, i);
                if (dp[j] && wordDictionary.contains(currentSubString)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }
}
