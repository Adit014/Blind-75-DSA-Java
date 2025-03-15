//https://leetcode.com/problems/valid-anagram/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] str = new int[26];
        int[] tar = new int[26];

        for (int i = 0; i < s.length(); i++) {
            str[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            tar[t.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < 26; i++) {
            if (str[i] != tar[i]) return false;
        }
        return true;
    }
}
