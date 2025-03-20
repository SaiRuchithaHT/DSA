class Solution {
    public int maxFrequency(int[] nums, int k) {
        if(nums.length==1)
            return 1;
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        int maxFreq = 1;
        for(int i=1; i<nums.length; i++)
            prefixSum[i] = prefixSum[i-1]+nums[i];
        for(int i=-1, j=1; i<nums.length && j<nums.length; ){
            if(k >= ((long)nums[j] * (j - i)) - ((long)prefixSum[j] - (i >= 0 ? prefixSum[i] : 0))) {
                maxFreq = Math.max(maxFreq, (j-i));
                j++;
            }
            else{
                i++;
            }
        }
        return maxFreq;
    }
}