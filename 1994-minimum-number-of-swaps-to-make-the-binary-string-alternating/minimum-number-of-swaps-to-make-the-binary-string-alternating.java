class Solution {
    public int minSwaps(String s) {
        int oneCount = 0, zeroCount = 0;
        for(char c: s.toCharArray()){
            if(c=='0')
                zeroCount++;
            else 
                oneCount++;
        }
        if((int)Math.abs(zeroCount-oneCount)>=2)
            return -1;
        StringBuilder str = new StringBuilder();
        boolean isZeroFirst = true;
        boolean isCheck = zeroCount==oneCount ? true : false;
        if(oneCount>zeroCount)
            isZeroFirst = false;
        String zero = "0";
        String one = "1";
        while(oneCount>0 || zeroCount>0){
            if(isZeroFirst){
                str.append(zero);
                zeroCount--;
            } else{
                str.append(one);
                oneCount--;
            }
            isZeroFirst = !isZeroFirst;
        }
        int diff = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=str.charAt(i))
                diff++;
        }
        diff = diff/2;
        return isCheck? Math.min(s.length()/2-diff, diff) : diff;
    }
}