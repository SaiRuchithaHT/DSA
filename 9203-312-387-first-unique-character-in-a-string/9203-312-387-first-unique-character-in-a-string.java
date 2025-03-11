class Solution {
    public int firstUniqChar(String s) {
        int[] charArray =  new int[26];
        Arrays.fill(charArray, 0);
        for(int i=0; i<s.length(); i++){
            charArray[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            if(charArray[s.charAt(i)-'a'] == 1)
                return i;
        }
        return -1;
    }
}