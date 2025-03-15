//https://leetcode.com/problems/3sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> answer = new ArrayList<>();
        int length = arr.length;

        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    answer.add(List.of(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while (left < right && arr[left] != arr[left] - 1) left ++;
                    while (left < right && arr[right] != arr[right] + 1) right --;
                } else if (sum > 0) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return answer;
    }
}
