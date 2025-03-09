class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] max = new int[nums.length];
        Arrays.fill(max, 1);
        for(int i=nums.length-2; i>=0; i--){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]<nums[j]){
                    max[i] = Math.max(max[i], 1+max[j]);
                }
            }
        }
        int maxV = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(maxV<max[i])
                maxV = max[i];
        }
        return maxV;
    }
}