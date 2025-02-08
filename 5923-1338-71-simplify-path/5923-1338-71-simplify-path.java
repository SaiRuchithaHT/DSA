class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<path.length(); i++){
            if(path.charAt(i)=='/'){
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                while(i<path.length() && path.charAt(i)!='/' ){
                    sb.append(String.valueOf(path.charAt(i)));
                    i++;
                }
                i--;
                String str = sb.toString();
                if(str.equals("."))
                    continue;
                else if(str.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }else
                    stack.push(str.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());          
            res.insert(0,"/");  
        }
        return res.toString().length()==0 ? "/" : res.toString();
    }
}