class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 1 100 1 1 1 100 1 1 100 1
        // 6 6 105 5 5 4 102 3 2 100 1
        int[] costArray = new int[cost.length+1];
        for(int i=cost.length; i>=0; i--){
            if(i==cost.length || i==cost.length-1)
                costArray[i] = cost[i-1];
            else if(i==0)
                costArray[i] = Math.min(costArray[i+1], costArray[i+2]);
            else{
                costArray[i] = Math.min(cost[i-1]+costArray[i+1], cost[i-1]+costArray[i+2]);
            }
        }
        return costArray[0];
    }
}