class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        boolean isZeroArray = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                left = Math.min(left, i);
                right = Math.max(right, i);
                isZeroArray = true;
            } else if(isZeroArray){
                isZeroArray = false;
                count += (long)(right-left+1)*(right-left+2)/2;
                left = Integer.MAX_VALUE; 
                right = Integer.MIN_VALUE;
            }
        }
        if(isZeroArray)
            count += (long)(right-left+1)*(right-left+2)/2;
        return count;
    }
}