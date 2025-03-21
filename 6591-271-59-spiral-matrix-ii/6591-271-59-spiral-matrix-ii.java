class Solution {
    public int[][] generateMatrix(int n) {
        int[][] dp = new int[n][n];
        int i=0, j=0, count=1, end = 0;
        while(count<=n*n){
            for( ; j<n-end && count<=n*n; j++, count++)
                dp[i][j] = count;
            j--;
            i++;
            for( ; i<n-end && count<=n*n; i++, count++)
                dp[i][j] = count;
            i--;
            j--;
            for( ; j>=0+end && count<=n*n; j--, count++)
                dp[i][j] = count;
            i--;
            j++;
            end++;
            for( ; i>=0+end && count<=n*n; i--, count++)
                dp[i][j] = count;
            i = end;
            j = end;
        }
        return dp;
    }
}