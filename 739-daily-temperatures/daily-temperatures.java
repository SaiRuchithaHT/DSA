class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int minTemp = temperatures[n-1];
        for(int i=n-2; i>=0; i--){
            if(temperatures[i]<temperatures[i+1])
                ans[i] = 1;
            else{
                if(ans[i+1]==0)
                    continue;
                int j=i+1+ans[i+1];
                while(j<n){
                    if(temperatures[i]<temperatures[j]){
                        ans[i] = j-i;
                        break;
                    } else {
                        if(ans[j]==0)
                            break;
                        j = j+ans[j];
                    }
                }
            }
        }
        return ans;
    }
}