class Solution {
    public int[] plusOne(int[] digits) {
        int itr = digits.length-1;
        while(itr >= 0){
            if(digits[itr]+1 <= 9){
                digits[itr] = digits[itr] + 1;
                return digits;
            }
            digits[itr] = 0;
            itr--;
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        for(int i = 1; i<result.length; i++){
            result[i] = 0;
        }
        return result;
    }
}