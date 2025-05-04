class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        if(dominoes.length==1)
            return 0;
        for(int i=0; i<dominoes.length; i++){
            if(dominoes[i][0]>dominoes[i][1]){
                int tmp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = tmp;
            }
        }
        Arrays.sort(dominoes, (a,b) -> {
            if(a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[0], b[0]);
        });
        int count = 0;
        int left = 0;
        for (int right = 1; right <= dominoes.length; right++) {
            if (right < dominoes.length &&
                dominoes[left][0] == dominoes[right][0] &&
                dominoes[left][1] == dominoes[right][1]) {
                continue;
            } else {
                int n = right - left;
                if (n > 1)
                    count += n * (n - 1) / 2;
                left = right;
            }
        }
        return count;
    }
}