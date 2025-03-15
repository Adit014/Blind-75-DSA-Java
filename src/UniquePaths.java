//https://leetcode.com/problems/unique-paths/description/

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] previousRow = new int[n];
        Arrays.fill(previousRow, 1);

        for (int i = 1; i < m; i++) {
            int[] currentRow = new int[n];
            Arrays.fill(previousRow, 1);
            for (int j = 1; j < n; j++) {
                currentRow[i] = currentRow[i-1] + previousRow[i];
            }

            previousRow = currentRow;
        }

        return previousRow[n-1];
    }
}
