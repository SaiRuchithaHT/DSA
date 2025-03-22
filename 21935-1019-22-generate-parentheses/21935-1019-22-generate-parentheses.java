class Solution {
    public void parenthesis(List<String> list, StringBuilder str, int open, int close, int n){
        if(str.length()==2*n){
            list.add(str.toString());
            return;
        }
        if(open<n){
            str.append("(");
            parenthesis(list, str, open+1, close, n);
            str.deleteCharAt(str.length()-1);
        }
        if(close<open && close<n){
            str.append(")");
            parenthesis(list, str, open, close+1, n);
            str.deleteCharAt(str.length()-1);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        parenthesis(list, str, 0, 0, n);
        return list;
    }
}