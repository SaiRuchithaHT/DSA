class Solution {
    public int maximumDifference(int[] nums) {
        int maxI = -1, maxJ = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(min>num){
                min = num;
                maxI = i;
            }
            if(num>min){
                max = num;
                maxJ = i;
            }
            ans = maxI<maxJ ? Math.max(ans, (max-min)) : ans;
            System.out.println("nums "+num+" max "+max+" min "+min+" ans "+ans);
        }
        return ans;
    }
}