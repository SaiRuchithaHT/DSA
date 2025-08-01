class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0, sum = 0;
        for(int i=1; i<=arr.length; i++){
            sum = sum + arr[i-1];
            if(i<k){
                continue;
            }
            if(sum/k >= threshold)
                count++;
            sum = sum - arr[i-k];
        }
        return count;
    }
}