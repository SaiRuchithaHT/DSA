class Solution {
    int ROW;
    int COL;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW = heights.length;
        COL = heights[0].length;
        boolean[][] pac = new boolean[ROW][COL];
        boolean[][] atl = new boolean[ROW][COL];
        for(int c=0; c<COL; c++){
            dfs(0, c, pac, heights);
            dfs(ROW-1, c, atl, heights);
        }
        for(int r=0; r<ROW; r++){
            dfs(r, 0, pac, heights);
            dfs(r, COL-1, atl, heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                if(pac[i][j] & atl[i][j]){

                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    public void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;
        for(int[] d : dir){
            int R = r+d[0];
            int C = c+d[1];
            if(R>=0 && R<ROW && C>=0 && C<COL
                && !ocean[R][C] && heights[R][C]>=heights[r][c]){
                    dfs(R, C, ocean, heights);
                }
        }
    }
}