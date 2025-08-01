class Solution {
    public int maxSumDivThree(int[] nums) {
        int oneRemainder = 100000;
        int twoRemainder = 200000;
        int sum = 0;
        for(int num : nums){
            sum = sum + num;
            if(num%3==1){
                twoRemainder = Math.min(twoRemainder, oneRemainder + num);
                oneRemainder = Math.min(oneRemainder, num);
            }
            if(num%3==2){
                oneRemainder = Math.min(oneRemainder, twoRemainder + num);
                twoRemainder = Math.min(twoRemainder, num);
            }
        }
        if(sum%3==0)
            return sum;
        else if(sum%3==1)
            return sum-oneRemainder;
        else if(sum%3==2) 
            return sum-twoRemainder;
        return 0;
    }
}