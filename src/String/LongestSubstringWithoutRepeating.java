//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int maxLength = Integer.MIN_VALUE;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            } else {
                int length = right - left + 1;
                maxLength = Math.max(length, maxLength);
            }

            map.put(ch, right);
            right = right + 1;
        }
        return maxLength;
    }
}
