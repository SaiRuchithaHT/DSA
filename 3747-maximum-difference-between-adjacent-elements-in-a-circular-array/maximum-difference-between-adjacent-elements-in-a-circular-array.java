class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE, n = nums.length;
        for(int i=1; i<=n; i++){
            max = Math.max(max, Math.abs(nums[i%n]-nums[(i-1)%n]));
        }
        return max;
    }
}