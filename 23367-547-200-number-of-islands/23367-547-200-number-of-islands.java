class Solution {
    public void dfs(int i, int j, int[][] visited, char[][] grid, int rowLen, int colLen) {
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen || visited[i][j] == 1 || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = 1;
        dfs(i + 1, j, visited, grid, rowLen, colLen); 
        dfs(i - 1, j, visited, grid, rowLen, colLen); 
        dfs(i, j + 1, visited, grid, rowLen, colLen); 
        dfs(i, j - 1, visited, grid, rowLen, colLen); 
    }
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] visited = new int[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    islands++; 
                    dfs(i, j, visited, grid, rowLen, colLen);
                }
            }
        }
        return islands;
    }
}