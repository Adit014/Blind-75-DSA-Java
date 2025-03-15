//https://leetcode.com/problems/longest-palindromic-substring/

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i  = 0; i < s.length(); i++) {
            int low = i;
            int high =i;

            while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low --;
                high ++;
            }

            String currentString = s.substring(low  + 1, high);

            if (longestPalindrome.length() < currentString.length()) {
                longestPalindrome = currentString;
            }

            low = i;
            high = i+1;

            while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low --;
                high ++;
            }

            currentString = s.substring(low  + 1, high);

            if (longestPalindrome.length() < currentString.length()) {
                longestPalindrome = currentString;
            }
        }
        return longestPalindrome;
    }
}
