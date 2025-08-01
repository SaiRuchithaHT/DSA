class Solution {
    public int calculate(int mid, int[] weights){
        int days = 1;
        int sum = 0;
        for(int weight : weights){
            if(weight > mid) return Integer.MAX_VALUE;
            if(sum + weight > mid){
                days++;
                sum = 0;
            }
            sum += weight;
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0;
        for(int weight : weights){
            min = Math.max(min, weight);  
            max += weight;               
        }

        int ans = max;
        while(min <= max){
            int mid = min + (max - min) / 2;
            int requiredDays = calculate(mid, weights);
            if(requiredDays > days){
                min = mid + 1;
            } else {
                ans = mid;
                max = mid - 1;
            }
        }
        return ans;
    }
}
