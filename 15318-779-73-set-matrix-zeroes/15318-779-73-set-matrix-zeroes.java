class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int r = 0;
        int c = 0;

        for(int i=0; i<m; i++){
            if(matrix[i][0]==0){
                c = 1;
                break;
            }
        }
        for(int i=0; i<n; i++){
            if(matrix[0][i]==0){
                r = 1;
                break;
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<m; i++){
            if(matrix[i][0]==0){
                for(int j=0; j<n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i=1; i<n; i++){
            if(matrix[0][i]==0){
                for(int j=0; j<m; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(r==1){
            for(int j=0; j<n; j++){
                matrix[0][j] = 0;
            }
        }
        if(c==1){
            for(int j=0; j<m; j++){
                matrix[j][0] = 0;
            }
        }
    }
}