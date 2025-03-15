import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int target, int total, int index, List<Integer> comb,
            List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(comb));
        }
        if (total > target || index > candidates.length) return;
        comb.add(candidates[index]);

        combinationSum(candidates, target, total + candidates[index], index, comb, result);
        comb.remove(comb.size() - 1);

        combinationSum(candidates, target, total, index + 1, comb, result);
    }
}
