//https://leetcode.com/problems/number-of-islands/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islands = 0;
        Set<String> visited = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited.contains(i+","+j)) {
                    islands++;
                    traverse(i,j,rows,cols,grid,visited);
                }
            }
        }
        return islands;
    }

    private void traverse(int r, int c, int rows, int cols, char[][] grid, Set<String> visited) {
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        visited.add(r+","+c);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r,c});

        while(!q.isEmpty()) {
            int [] poll = q.poll();
            for (int[] arr : directions) {
                int nr = poll[0] + arr[0];
                int nc = poll[1] + arr[1];

                if (nr >= 0 && nr < rows && nc >=0 && nc < cols && grid[nr][nc] == '1' && !visited.contains(nr+","+nc)) {
                    q.add(new int[]{nr,nc});
                    visited.add(nr+","+nc);
                }
            }
        }
    }
}
