class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        if(usageLimits.size()==1)
            return 1;
        Collections.sort(usageLimits);
        long count = 1, sum = 0;
        int i = 0;
        while(i<usageLimits.size()){
            sum += (int)usageLimits.get(i);
            if(count<=usageLimits.get(i) || count*(count+1)/2 <= sum)
                count++;
            i++;
        }
        return (int)--count;
    }
}