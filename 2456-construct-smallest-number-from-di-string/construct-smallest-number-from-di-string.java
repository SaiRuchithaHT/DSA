class Solution {
    public String smallestNumber(String pattern) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=0, j=2, k=0; i<pattern.length(); i++, j++){
            if(pattern.charAt(i)=='I'){
                list.add(j);
                k = i+1;
            }else{
                list.add(k, j);
            }
        }
        long res = 0;
        for(int num : list){
            res = res*10+num;
        }
        return String.valueOf(res);
    }
}