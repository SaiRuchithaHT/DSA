class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxLen = 0;
        for(int i=0, j=0; j<s.length(); j++){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            if(((j-i+1)-maxFreq)>k){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
            }
            maxLen = Math.max((j-i+1), maxLen);
        }
        return maxLen;
    }
}