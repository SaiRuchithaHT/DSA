class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixSum = new int[n];
        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                prefixSum[i] = (i == 0) ? 1 : prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = (i == 0) ? 0 : prefixSum[i - 1];
            }
        }
        
        int lastCandle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lastCandle = i;
            }
            leftCandle[i] = lastCandle;
        }
        
        lastCandle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastCandle = i;
            }
            rightCandle[i] = lastCandle;
        }
        
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int left = rightCandle[l]; 
            int right = leftCandle[r]; 
            
            if (left != -1 && right != -1 && left < right) {
                ans[i] = prefixSum[right] - prefixSum[left];
            }
        }
        
        return ans;
    }
}
