class Solution {
    public int getLargestOutlier(int[] nums) {
        int maxOutlier = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int num : nums){
            sum = sum+num;
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num : nums){
            int outlierRemSum = sum-num;
            // System.out.println("outlierRemSum = "+outlierRemSum);
            if(Math.abs(outlierRemSum)%2 == 1)
                continue;
            int letOutlier = num;
            // System.out.println("letOutlier = "+letOutlier);
            int sumNumber = outlierRemSum/2;
            // System.out.println("map = "+map);
            if(sumNumber!=letOutlier && map.containsKey(sumNumber))
                maxOutlier = Math.max(maxOutlier, letOutlier);
            else if(sumNumber==letOutlier && map.containsKey(sumNumber) && map.get(sumNumber)>1)
                maxOutlier = Math.max(maxOutlier, letOutlier);
        }
        return maxOutlier;
    }
}