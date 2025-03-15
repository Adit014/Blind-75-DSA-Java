import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
public class TopKElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] freqList= new ArrayList[nums.length + 1];

        for (int i = 0; i < freqList.length; i++) {
            freqList[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> keySet : counter.entrySet()) {
            int frequency = keySet.getValue();
            freqList[frequency].add(keySet.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = freqList.length - 1; i >= 0; i--) {
            for (int num : freqList[i]) {
                res[idx++] = num;
                if (idx == k) {
                    return res;
                }
            }
        }
        return new int[0];
    }
}
