class Solution {
    class Pair{
        int count;
        char c;
        Pair(int count, char c){
            this.count = count;
            this.c = c;
        }
    }
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        for(char c : s.toCharArray())
            charCount[c-'a']++;
        Queue<Pair> queue = new PriorityQueue<>((a,b) -> (b.count-a.count));
        for(int i=0; i<26; i++)
            if(charCount[i]>0) queue.offer(new Pair(charCount[i], (char)(i+'a')));
        
        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(result.length()==0 || result.charAt(result.length()-1)!=p.c){
                result.append(String.valueOf(p.c));
                if(p.count>1)
                    queue.offer(new Pair(p.count-1, p.c));
            } else {
                if (queue.isEmpty()) {
                    return "";
                }
                Pair p2 = queue.poll();
                result.append(String.valueOf(p2.c));
                if(p2.count>1)
                    queue.offer(new Pair(p2.count-1, p2.c));
                queue.offer(p);
            }
        }
        return result.toString();
    }
}