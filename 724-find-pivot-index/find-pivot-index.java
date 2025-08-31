class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0; i<n; i++){
            if(i==0){
                left[i] = 0;
                right[n-i-1] = 0;
            } else {
                left[i] = left[i-1] + nums[i-1];
                right[n-i-1] = right[n-i] + nums[n-i];
            }
        }
        // System.out.println("left+" + Arrays.toString(left));
        // System.out.println("right+" + Arrays.toString(right));
        for(int i=0; i<n; i++){
            if(left[i]==right[i])
                return i;
        }
        return -1;
    }
}