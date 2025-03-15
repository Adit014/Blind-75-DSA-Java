// https://leetcode.com/problems/longest-common-subsequence/

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcade", "aceaa"));
    }
    public int longestCommonSubsequence(String first, String second) {
        int[] dp = new int[first.length()];
        int longest = Integer.MIN_VALUE;

        for (char ch : second.toCharArray()) {
            int currentLength = 0;
            for (int i = 0; i < dp.length; i++) {
                if (currentLength < dp[i]) {
                    currentLength = dp[i];
                } else if (first.charAt(i) == ch) {
                    dp[i] = currentLength + 1;
                    longest = Math.max(longest, currentLength + 1);
                }
            }
        }
        return longest;
    }
}
