class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n+1];
        Arrays.sort(rides, (a, b) -> Integer.compare(a[1], b[1]));
        int rideIndex = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            
            while (rideIndex < rides.length && rides[rideIndex][1] == i) {
                int start = rides[rideIndex][0];
                int end = rides[rideIndex][1];
                int tip = rides[rideIndex][2];
                
                dp[end] = Math.max(dp[end], dp[start] + (end - start) + tip);
                rideIndex++;
            }
        }
        
        return dp[n];
    }
}