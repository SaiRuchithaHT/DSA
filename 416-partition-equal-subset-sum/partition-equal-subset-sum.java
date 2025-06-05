class Solution {
    public boolean canPartition(int[] nums) {
        //    1 2 3 4 5 6 7 8 9 10 11
        // 1. t f f f f f f f f  f  f
        // 5. t 
        // 5
        // 11 
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum%2==1)
            return false;
        sum = sum/2;
        boolean[][] dp = new boolean[nums.length][sum+1];
        for(int i=0; i<nums.length; i++){
            dp[i][0] = true;
        }
        Arrays.sort(nums);
        if (nums[0] <= sum)
            dp[0][nums[0]] = true;
        int toSum = nums[0];
        for(int i=1; i<nums.length; i++){
            toSum += nums[i];
            for(int j=1; j<=toSum && j<=sum; j++){
                if(dp[i-1][j]==true)
                    dp[i][j] = true;
                else{
                    if(j>=nums[i]){
                        dp[i][j] = dp[i-1][j-nums[i]];
                    }
                }
            }
        }
        // for(int i=0; i<nums.length; i++){
        //     for(int j=0; j<=sum; j++){
        //         System.out.print(dp[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        return dp[nums.length-1][sum];
    }
}