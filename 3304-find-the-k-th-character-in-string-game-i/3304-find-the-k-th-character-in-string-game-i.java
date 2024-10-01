class Solution {
    public char kthCharacter(int k) {
        if(k==1)
            return 'a';
        StringBuilder begin = new StringBuilder("a");
        StringBuilder res = new StringBuilder();
        int num = 1;
        while(num<k){
            StringBuilder temp = new StringBuilder(begin);
            res.append(begin);
            for(int i=0; i<begin.length(); i++){
                begin.setCharAt(i, begin.charAt(i)=='z' ? 'a' : (char)(begin.charAt(i)+1));
            }
            res.append(begin);
            if(num==1)
                temp.setCharAt(0, 'b');
            else
                temp.append(begin);
            begin = new StringBuilder(temp);
            num = num*2;
        }
        return res.charAt(k-1);
    }
}