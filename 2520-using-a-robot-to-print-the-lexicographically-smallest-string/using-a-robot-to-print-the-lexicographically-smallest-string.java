class Solution {
    public int smallestChar(int[] freq){
        for(int i=0; i<26; i++){
            if(freq[i]>0){ 
                return i;
            }
        }
        return 0;
    }
    public String robotWithString(String s) {
        Stack<Character> t = new Stack<>();
        int[] freq = new int[26];
        StringBuilder res = new StringBuilder();
        int n = s.length();

        for(int i=0; i<n; i++)
            freq[s.charAt(i)-'a']++;

        for(int i=0; i<n; i++){
            t.push(s.charAt(i));
            freq[s.charAt(i)-'a']--;
            
            while(!t.isEmpty() && ((t.peek()-'a')<=smallestChar(freq))){
                res.append(t.pop());
            }
        }
        while (!t.isEmpty()) {
            res.append(t.pop());
        }
        return res.toString();
    }
}