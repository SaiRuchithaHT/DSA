class Solution {
    public int maxPower(String s) {
        char prev = '.';
        int length = 1, maxLength = 1;
        for(char c : s.toCharArray()){
            if(prev==c)
                length++;
            else{
                prev = c;
                length = 1;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}