//https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.ArrayList;
import java.util.List;

public class LongestIncSubSequence {
    public static void main(String[] args) {
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (result.isEmpty() || (result.get(result.size() - 1) < num)) {
                result.add(num);
            } else {
                int index = binarySearch(result, num);
                result.set(index, num);
            }
        }
        return result.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) == target) return mid;
            else if (list.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
