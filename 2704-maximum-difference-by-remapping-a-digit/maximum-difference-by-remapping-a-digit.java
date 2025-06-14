class Solution {
    public int minMaxDifference(int num) {
        char[] maxNum = String.valueOf(num).toCharArray();
        char[] minNum = String.valueOf(num).toCharArray();
        for(int i=0; i<maxNum.length; i++){
            if((maxNum[i]-'0')!=9){
                char c = maxNum[i];
                for(int j=0; j<maxNum.length; j++){
                    if(maxNum[j]==c)
                        maxNum[j] = '9';
                }
                break;
            }
        }
        for(int i=0; i<minNum.length; i++){
            if((minNum[i]-'0')!=0){
                char c = minNum[i];
                for(int j=0; j<minNum.length; j++){
                    if(minNum[j]==c)
                        minNum[j] = '0';
                }
                break;
            }
        }
        return Integer.valueOf(new String(maxNum))-Integer.valueOf(new String(minNum));
    }
}