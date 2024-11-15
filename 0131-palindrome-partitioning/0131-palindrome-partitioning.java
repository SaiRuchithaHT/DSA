class Solution {
    public Boolean isPalindrome(String s){
        if(s.length()==0)
            return false;
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
    public void partitionHelper(int ind, String s, List<String> ds, List<List<String>> res){
        if(ind == s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<s.length(); i++){
            if(isPalindrome(s.substring(ind, i+1))){
                ds.add(s.substring(ind, i+1));
                partitionHelper(i+1, s, ds, res);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        partitionHelper(0, s, ds, res);
        return res;
    }
}