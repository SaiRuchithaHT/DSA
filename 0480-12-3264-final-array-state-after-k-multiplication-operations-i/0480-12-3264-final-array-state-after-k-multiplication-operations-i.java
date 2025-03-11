class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int j=0; j<k; j++){
            int min = nums[0];
            int idx = 0;
            for(int i=1; i<nums.length; i++){
                if(min>nums[i]){
                    min = nums[i];
                    idx = i;
                }
            }
            nums[idx] = nums[idx]*multiplier;
        }
        return nums;
    }
}