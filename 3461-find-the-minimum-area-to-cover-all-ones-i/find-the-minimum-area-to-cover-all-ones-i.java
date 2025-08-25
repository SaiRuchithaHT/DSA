class Solution {
    public int minimumArea(int[][] grid) {
        int x_min = Integer.MAX_VALUE, x_max = -1, y_min = Integer.MAX_VALUE, y_max = -1;
        int height = grid.length, width = grid[0].length;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j]==1){
                    x_min = Math.min(x_min, i);
                    y_min = Math.min(y_min, j);
                    x_max = Math.max(x_max, i);
                    y_max = Math.max(y_max, j);
                }
            }
        }
        // System.out.println("x_min "+x_min);
        // System.out.println("x_max "+x_max);
        // System.out.println("y_min "+y_min);
        // System.out.println("y_max "+y_max);
        return (x_max-x_min+1)*(y_max-y_min+1);
    }
}