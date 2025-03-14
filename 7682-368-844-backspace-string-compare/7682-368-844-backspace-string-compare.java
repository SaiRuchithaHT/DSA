class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        int count = 0;
        for(int i=s.length()-1; i>=0; ){
            if(s.charAt(i)!='#'){
                if(count==0)
                    str1.append(s.substring(i, i+1));
                else
                    count--;
                i--;
            }
            else{
                while(i>=0 && s.charAt(i)=='#'){
                    count++;
                    i--;
                }
            }
        }
        count = 0;
        for(int i=t.length()-1; i>=0; ){
            if(t.charAt(i)!='#'){
                if(count==0)
                    str2.append(t.substring(i, i+1));
                else
                    count--;
                i--;
            }
            else{
                while(i>=0 && t.charAt(i)=='#'){
                    count++;
                    i--;
                }
            }
        }
        System.out.print("str1 "+str1+" str2 "+str2);
        return str1.toString().equals(str2.toString());
    }
}