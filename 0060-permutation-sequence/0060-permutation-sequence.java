class Solution {
    public int fact(int n){
        if(n<=1)
            return 1;
        return n*fact(n-1);
    }
    public StringBuilder permute(int n, int k, List<Integer> list, StringBuilder res){
        if(n==1 || k==0){
            res.append(list.get(0));
            return res;
        }
        int numToSel = fact(n-1);
        int numtoDiv, numtoRem;
        if(k%numToSel==0){
            numtoDiv = (k/numToSel)-1;
            numtoRem = numToSel;

        }else{
            numtoDiv = (k/numToSel);
            numtoRem = k%numToSel;
        }
        res.append(list.get(numtoDiv));
        list.remove(numtoDiv);
        res = permute(n-1, numtoRem, list, res);
        return res;
    }
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        StringBuilder res = new StringBuilder();
        res = permute(n, k, list, res);
        return res.toString();
    }
}