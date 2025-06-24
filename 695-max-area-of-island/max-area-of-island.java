class Solution {
    public int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length 
            || visited[i][j] || grid[i][j] == 0)
            return 0;

        visited[i][j] = true;
        int area = 1;
        area += dfs(i, j + 1, grid, visited);
        area += dfs(i, j - 1, grid, visited);
        area += dfs(i + 1, j, grid, visited);
        area += dfs(i - 1, j, grid, visited);
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int area = dfs(i, j, grid, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
