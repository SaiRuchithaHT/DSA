class Solution {
    public int minStartValue(int[] nums) {
        int min = nums[0], sum = nums[0];
        for(int i=1; i<nums.length; i++){
            sum += nums[i];
            if(min>sum)
                min = sum;
        }
        return min<1? 1-min : 1;
    }
}