//https://leetcode.com/problems/palindromic-substrings/

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count+=checkPalindromes(s, i, i);
            count+=checkPalindromes(s,i, i+1);
        }
        return count;
    }

    private int checkPalindromes(String s, int low, int high) {
        int count = 0;
        while (low >=0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low --;
            high ++;

            count ++;
        }
        return count;
    }
}
