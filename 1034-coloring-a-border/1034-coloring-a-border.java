import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        List<int[]> borders = new ArrayList<>();

        int prev = grid[row][col];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        vis[row][col] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            boolean isBorder = false;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    isBorder = true;
                } 
                else if (grid[nr][nc] != prev) {
                    isBorder = true;
                } 
                else if (!vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }

            if (isBorder) {
                borders.add(new int[]{r, c});
            }
        }

        // Apply color at the end
        for (int[] cell : borders) {
            grid[cell[0]][cell[1]] = color;
        }

        return grid;
    }
}