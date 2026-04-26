class Solution {

    public boolean dfs(int i, int j, int pi, int pj, char[][] grid, boolean[][] vis) {
        vis[i][j] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];

            // Boundary check
            if (ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length)
                continue;

            // Only move to same character
            if (grid[ni][nj] != grid[i][j])
                continue;

            // If already visited and not parent → cycle
            if (vis[ni][nj] && !(ni == pi && nj == pj))
                return true;

            // If not visited → DFS
            if (!vis[ni][nj]) {
                if (dfs(ni, nj, i, j, grid, vis))
                    return true;
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (dfs(i, j, -1, -1, grid, vis))
                        return true;
                }
            }
        }
        return false;
    }
}