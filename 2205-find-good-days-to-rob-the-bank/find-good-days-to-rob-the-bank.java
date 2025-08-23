class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        if(n<2*time+1)
            return new ArrayList<>();
        int[] dec = new int[n];
        int[] inc = new int[n];
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i==0)
                dec[i] = 0;
            else{
                if(security[i-1]>=security[i])
                    dec[i] = dec[i-1]+1;
            }
        }
        for(int i=n-1; i>=0; i--){
            if(i==(n-1))
                inc[i] = 0;
            else{
                if(security[i+1]>=security[i])
                    inc[i] = inc[i+1]+1;
            }
        }
        // System.out.print("dec: ");
        // for(int num: dec)
        //     System.out.print(num+" ");
        // System.out.println();
        // System.out.print("inc: ");
        // for(int num: inc)
        //     System.out.print(num+" ");
        for(int i=time; i<(n-time); i++){
            if(dec[i]>=time && inc[i]>=time)
                result.add(i);
        }
        return result;
    }
}