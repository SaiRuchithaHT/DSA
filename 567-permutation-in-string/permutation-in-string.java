class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1count = new int[26];
        for(int i=0; i<s1.length(); i++)
            s1count[s1.charAt(i)-'a']++;
        int[] s2count = new int[26];
        for(int i=0; i<s2.length(); i++){
            if(i<s1.length())
                s2count[s2.charAt(i)-'a']++;
            else {
                for(int j=0; j<=26; j++){
                    if(j==26)
                        return true;
                    if(s1count[j]!=s2count[j])
                        break;
                }
                s2count[s2.charAt(i-s1.length())-'a']--;
                s2count[s2.charAt(i)-'a']++;
            }
        }
        for(int j=0; j<=26; j++){
            if(j==26)
                return true;
            if(s1count[j]!=s2count[j])
                break;
        }
        return false;
    }
}