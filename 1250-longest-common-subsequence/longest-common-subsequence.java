class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //   a b c d e
        // a 1 1 1 1 1
        // c x 1 2 2 2
        // e x x 2 2 3

        //   u b m r a p g
        // e 0 0 0 0 0 0 0
        // z x 0 0 0 0 0 0
        // u x x 
        // p
        // k
        // r
        if(text1.length()<text2.length()){
            return longestCommonSubsequence(text2, text1);
        }
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int j=1; j<=n; j++){
            for(int i=1; i<=m; i++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[j][i] = 1+dp[j-1][i-1];
                } else{
                    dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
                }
            }
        }
        return dp[n][m];
    }
}