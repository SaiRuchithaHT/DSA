class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 27/8 = 4 // 1 2 2 3
        // 88/5 = 18 // 2 1 2 1 2
        // 88/6 = 15 //
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i : piles)
            max = Math.max(max, i);
        int mid;
        int ans = Integer.MAX_VALUE;
        while(min<=max){
            mid = min + (max-min)/2;
            long sum = 0;
            for(int pile : piles){
                // System.out.println((int)Math.ceil((double)pile/(double)mid));
                sum = sum + (long)Math.ceil((double)pile/mid);
            }
            // System.out.println("sum "+sum+" mid "+mid);
            if(sum<=h){
                ans = Math.min(ans, mid);
                max = mid - 1;
            } else{
                min = mid + 1;
            }
        }
        return ans;
    }
}