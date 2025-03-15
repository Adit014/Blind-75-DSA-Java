//https://leetcode.com/problems/pacific-atlantic-water-flow/

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(rows, cols, i, 0, pacific, 0, heights);
            dfs(rows, cols, i, cols - 1, atlantic, 0, heights);
        }

        for (int i = 0; i < cols; i++) {
            dfs(rows, cols, 0, i, pacific, 0, heights);
            dfs(rows, cols, rows - 1, i, pacific, 0, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int rows, int cols, int r, int c, boolean[][] visited, int previous, int[][] heights) {
        if (r < 0  || c < 0|| r >= rows || c >= cols || visited[r][c] || previous > heights[r][c]) {
            return;
        }
        visited[r][c] = true;
        dfs(rows, cols, r+1, c, visited, heights[r][c], heights);
        dfs(rows, cols, r - 1, c, visited, heights[r][c], heights);
        dfs(rows, cols, r, c + 1, visited, heights[r][c], heights);
        dfs(rows, cols, r, c - 1, visited, heights[r][c], heights);
    }
}
