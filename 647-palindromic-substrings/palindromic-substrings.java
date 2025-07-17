class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=i; j>=0; j--){
                if(i==j || (i==(j+1) && s.charAt(j)==s.charAt(i))){
                    res++;
                    dp[i][j] = true;
                    continue;
                }
                if((i-j)>=2 && s.charAt(j)==s.charAt(i) && dp[i-1][j+1]==true){
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }
}