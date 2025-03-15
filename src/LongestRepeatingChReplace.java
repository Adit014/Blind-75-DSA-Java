//https://leetcode.com/problems/longest-repeating-character-replacement/description/

public class LongestRepeatingChReplace {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, maxLen = 0;
        int[] freq = new int[26];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A'] ++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            if ((right - left + 1 - maxFreq) > k) {
                freq[s.charAt(left) - 'A']--;
                left = left + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
