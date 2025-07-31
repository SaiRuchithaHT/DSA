class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2==1)
            return new int[0];
        int[] res = new int[changed.length/2];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(changed);
        for(int num : changed)
            map.put(num, map.getOrDefault(num, 0)+1);
        for(int i=0, j=0; i<changed.length; i++){
            if(!map.containsKey(changed[i]) || map.get(changed[i])==0)
                continue;
            map.put(changed[i], map.get(changed[i])-1);
            if(!map.containsKey(changed[i]*2) || map.get(changed[i]*2)==0)
                return new int[0];
            map.put(changed[i]*2, map.get(changed[i]*2)-1);
            res[j++] = changed[i];
        }
        return res;
    }
}