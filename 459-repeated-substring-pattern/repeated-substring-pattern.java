class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i=1; i<=n/2; i++){
            String sub = s.substring(0,i);
            int j = i;
            while(s.indexOf(sub, j)==j){
                j = j+sub.length();
                if(j==s.length())
                    return true;
            }
        }
        return false;
    }
}