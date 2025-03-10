class Solution {
    public int findKthPositive(int[] arr, int k) {
        int miss = 0; 
        for(int i=0; i<arr.length && k>0;){
            miss++;
            if(arr[i] != miss){
                k--;
            }else{
                i++;
            }
        }
        while(k>0){
            k--;
            miss++;
        }
        return miss;
    }
}