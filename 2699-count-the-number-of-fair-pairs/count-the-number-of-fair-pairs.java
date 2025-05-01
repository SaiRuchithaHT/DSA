class Solution {
    public long pairs(int[] nums, int target){
        long count = 0;
        int left = 0, right = nums.length-1;
        while(left<right){
            long sum = nums[left] + nums[right];
            if(sum<target){
                count = count + right - left;
                left++;
            }
            else
                right--;
        }
        return count;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        // 0 1 4 4 5 7
        if(nums.length==1)
            return 0;
        Arrays.sort(nums);
        return pairs(nums, upper+1) - pairs(nums, lower);
    }
}