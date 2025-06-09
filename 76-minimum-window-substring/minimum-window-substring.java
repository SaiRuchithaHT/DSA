class Solution {
    public boolean doesContain(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        for(Map.Entry<Character, Integer> entry : tMap.entrySet()){
            if(!(sMap.containsKey(entry.getKey()) && (sMap.get(entry.getKey()) >= entry.getValue()))){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int windowLength = Integer.MAX_VALUE, start = 0, end = 0;
        for(char c : t.toCharArray())
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        for(int i=0, j=0; i<=j && j<=s.length(); ){
            if(doesContain(sMap, tMap)){
                if(windowLength > (j-i)){
                    windowLength = j-i;
                    start = i;
                    end = j;
                }
                // System.out.println(s.substring(i, j+1));
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))-1);
                i++;
            } else{
                if (j == s.length()) break; 
                sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0)+1);
                j++;
            }
        }
        return s.substring(start, end);
    }
}