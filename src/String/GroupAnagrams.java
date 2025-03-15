//https://leetcode.com/problems/group-anagrams/

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] str) {
        Map<String, List<String>> frequency = new HashMap<>();

        for (String s : str) {
            String key = getFrequencyKey(s);//get key
            if (frequency.containsKey(key)) {
                frequency.get(key).add(s);
            } else {
                frequency.put(key, new ArrayList<>(Arrays.asList(s)));
            }
        }
        return new ArrayList<>(frequency.values());
    }

    private String getFrequencyKey(String s) {
        int[] freqArr = new int[26];
        for (char ch : s.toCharArray()) {
            freqArr[ch - 'a']++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i =0; i < 26; i++) {
            if (freqArr[i] > 0) {
                builder.append((char) (freqArr[i] + 'a'));
                builder.append(freqArr[i]);
            }
        }
        return builder.toString();
    }
}
