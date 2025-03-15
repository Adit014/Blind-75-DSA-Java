//https://leetcode.com/problems/word-break/

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String word, List<String> list) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= word.length(); i++) {
            for (String s : list) {
                int start = i - s.length();
                if (start >=0 && dp[start] && word.substring(start, i).equals(s)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
