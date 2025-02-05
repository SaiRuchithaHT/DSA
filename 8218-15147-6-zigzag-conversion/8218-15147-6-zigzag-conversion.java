class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows==s.length())
            return s;
        StringBuilder res = new StringBuilder();
        Boolean flag = true;
        for(int i=0; i<numRows; i++){
            flag = true;
            for(int j=i; j<s.length(); ){
                res.append(Character.toString(s.charAt(j)));
                if(i==0 || i==(numRows-1)){
                    j = j+2*(numRows)-3+1;
                } else{
                    if(flag)
                        j = j+2*(numRows-i)-3+1;
                    else
                        j = j+2*(i+1)-3+1;
                    flag = !flag;
                }
            }
        }
        return res.toString();
    }
}