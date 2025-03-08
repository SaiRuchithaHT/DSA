class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min;
        int blackCount = 0;
        for(int i=0; i<k; i++){
            if(blocks.charAt(i)=='B')
                blackCount++;
        }
        min = k - blackCount;
        for(int i=k; i<blocks.length(); i++){
            if(blocks.charAt(i)=='B')
                blackCount++;
            if(blocks.charAt(i-k)=='B')
                blackCount--;
            if(min > (k-blackCount))
                min = k-blackCount;
        }
        return min;
    }
}