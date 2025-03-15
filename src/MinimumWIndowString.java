// https://leetcode.com/problems/minimum-window-substring/

import java.util.Arrays;

public class MinimumWIndowString {
    public static void main(String[] args) {
         new MinimumWIndowString().minWindow("ADOBECODEBANC", "ABC");
    }
    public String minWindow(String s, String t) {
        char[] str = s.toCharArray();
        char[] tar = t.toCharArray();

        String answer = "";
        int count = 0;

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;

        int[] freq = new int[128];
        for (char ch : tar) {
            freq[ch] = freq[ch] + 1;
        }

        while(right < str.length) {
            freq[str[right]]--;
            System.out.println(str[right]);
            System.out.println(Arrays.toString(freq));
            if (freq[str[right]] >= 0) {
                count ++;
            }

            while (count == tar.length) {
                int currentLength = right - left + 1;
                if (minLength > currentLength) {
                    minLength = currentLength;
                    answer = s.substring(left, right + 1);
                    System.out.println("Settng answer to " + answer);
                }

                freq[str[left]]++;

                if (freq[str[left]] > 0) {
                    count --;
                }
                left ++;
            }
            right ++;
        }
        return answer;
    }

}
