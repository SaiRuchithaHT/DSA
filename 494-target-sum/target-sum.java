class Solution {
    int count = 0;
    public void recursive(int index, int n, int[] nums, int target){
        if(target==0 && index==n){
            count++;
            return;
        }
        if(index==n)
            return;
        recursive(index+1, nums.length, nums, target+nums[index]);
        recursive(index+1, nums.length, nums, target-nums[index]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        recursive(0, nums.length, nums, target);
        return count;
    }
}