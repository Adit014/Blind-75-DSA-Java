//https://leetcode.com/problems/longest-consecutive-sequence/description/

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxCount = Integer.MIN_VALUE;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num-1)) {
                int count = 1;
                while (set.contains(++num)) count++;
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}
