class Solution {
    public String pushDominoes(String dominoes) {
        // + R
        // - L
        // * both
        char[] itr = dominoes.toCharArray();
        for(int i=1; i<dominoes.length(); i++){
            if(itr[i]=='.' && (itr[i-1]=='R' || itr[i-1]=='+'))
                itr[i] = '+';
        }
        for(int i=dominoes.length()-2; i>=0; i--){
            if((itr[i]=='.' || itr[i]=='+') && (itr[i+1]=='L' || itr[i+1]=='-' || itr[i+1]=='*')){
                if(itr[i]=='+')
                    itr[i] = '*';
                else
                    itr[i] = '-';
            }
        }
        for(int i=0; i<dominoes.length(); i++){
            if(itr[i]=='+')
                itr[i] = 'R';
            else if(itr[i]=='-')
                itr[i] = 'L';
            else if(itr[i]=='*'){
                int slow = i;
                int fast = i;
                while(fast<dominoes.length() && itr[fast]=='*'){
                    itr[slow] = 'R';
                    slow = slow+1;
                    fast = fast+2;
                }
                fast = slow;
                slow = slow-1;
                while(fast<dominoes.length() && itr[fast]=='*'){
                    itr[fast] = 'L';
                    fast = fast+1;
                }
                System.out.print("i "+i+" slow "+slow+" fast "+fast);
                if((slow-i+1)==(fast-slow))
                    itr[slow] = '.';
                i = fast-1;
            }
        }
        return new String(itr);
    }
}