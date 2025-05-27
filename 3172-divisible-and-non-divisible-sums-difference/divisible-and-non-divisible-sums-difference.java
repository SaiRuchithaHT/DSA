class Solution {
    public int differenceOfSums(int n, int m) {
        int sum1 = n*(n+1)/2;
        int sum2 = 0;
        for(int i = m; i<=n; i=i+m){
            sum1 = sum1-i;
            sum2 = sum2+i;
        }
        return sum1-sum2;
    }
}