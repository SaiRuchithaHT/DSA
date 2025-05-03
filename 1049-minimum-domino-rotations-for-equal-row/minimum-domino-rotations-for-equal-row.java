class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        for (int i = 1; i < tops.length; i++) {
            if (tops[i] != tops[i - 1])
                break;
            if (i == (tops.length - 1))
                return 0;
        }
        for (int i = 1; i < bottoms.length; i++) {
            if (bottoms[i] != bottoms[i - 1])
                break;
            if (i == (bottoms.length - 1))
                return 0;
        }
        int[] map = new int[7];
        for (int i = 0; i < tops.length; i++) {
            map[tops[i]] = map[tops[i]] + 1;
            map[bottoms[i]] = map[bottoms[i]] + 1;
        }
        int[] nums = { 0, 0 };
        for (int i = 1, j = 0; i <= 6; i++) {
            if (map[i] >= tops.length) {
                nums[j++] = i;
            }
        }
        int count1 = 0, same1 = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != nums[0] && bottoms[i] != nums[0]) {
                count1 = tops.length+1;
                break;
            }
            if(tops[i] != nums[0])
                count1++;
            if (tops[i] == nums[0] && bottoms[i] == nums[0]) 
                    same1++;
        }
        count1 = Math.min(count1, (tops.length-count1-same1));
        int count2 = tops.length+1, same2 = 0;
        if (nums[1] != 0){
            count2 = 0;
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != nums[1] && bottoms[i] != nums[1]) {
                    count2 = tops.length+1;
                    break;
                }
                if(tops[i] != nums[1])
                    count2++;
                if (tops[i] == nums[1] && bottoms[i] == nums[1]) 
                    same2++;
            }
            count2 = Math.min(count2, (tops.length-count2-same2));
        }

        return Math.min(count1, count2) <= 0 ? -1 : Math.min(count1, count2);
    }
}