class Solution {
    public int binarySearch(int[] nums, int lo, int hi, int n){
        int mid = lo+(hi-lo)/2;
        if(nums[mid]>nums[mid+1])
            return nums[mid+1];
        else if(nums[mid-1]>nums[mid])
            return nums[mid];

        if(nums[lo]<nums[mid])
            return binarySearch(nums, mid, hi, nums.length);
        else
            return binarySearch(nums, lo, mid, nums.length);
    }
    public int findMin(int[] nums) {
        if(nums.length ==1 || nums[0]<nums[nums.length-1])
            return nums[0];
        return binarySearch(nums, 0, nums.length-1, nums.length);
    }
}