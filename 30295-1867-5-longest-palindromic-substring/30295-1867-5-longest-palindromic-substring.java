class Solution {
    public String longestPalindrome(String s) {
        int[][] res = new int[s.length()][s.length()];
        StringBuilder rev = new StringBuilder(s);
        String revS = rev.reverse().toString();
        int maxCount = 0, endIdx = 0, n = s.length();
        String longPal = "";
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<revS.length(); j++){
                if(s.charAt(i)==revS.charAt(j)){
                    if(i==0 || j==0)
                        res[i][j] = 1;
                    else 
                        res[i][j] = res[i-1][j-1] + 1;
                    if (res[i][j] > maxCount) {
                        int beforeRevIdx = n - 1 - j; 
                        if (beforeRevIdx + res[i][j] - 1 == i) { 
                            maxCount = res[i][j];
                            endIdx = i; 
                        }
                    }
                } else
                    res[i][j] = 0;
            }
        }
        return s.substring(endIdx - maxCount + 1, endIdx + 1);
    }
}