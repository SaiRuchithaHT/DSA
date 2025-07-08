class Solution {
    public boolean dfs(int i, int j, int m, int n, char[][] board, boolean[][] visited, List<int[]> region){
        if (i < 0 || j < 0 || i >= m || j >= n)
            return false; // Went outside, i.e. touches border

        if (board[i][j] == 'X' || visited[i][j])
            return true;

        visited[i][j] = true;
        region.add(new int[]{i, j});

        boolean up = dfs(i - 1, j, m, n, board, visited, region);
        boolean right = dfs(i, j + 1, m, n, board, visited, region);
        boolean down = dfs(i + 1, j, m, n, board, visited, region);
        boolean left = dfs(i, j - 1, m, n, board, visited, region);

        return up && right && down && left;
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    List<int[]> region = new ArrayList<>();
                    boolean surrounded = dfs(i, j, m, n, board, visited, region);
                    if (surrounded) {
                        for (int[] cell : region) {
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
}
