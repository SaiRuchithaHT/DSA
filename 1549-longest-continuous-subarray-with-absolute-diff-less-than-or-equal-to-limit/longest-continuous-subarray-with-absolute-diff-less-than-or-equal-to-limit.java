import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, maxLength = 0;

        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}
