import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        Set<String> powers = new HashSet<>();
        for (long i = 1; i <= 1_000_000_000; i *= 2) {
            powers.add(sortedDigits(i));
        }
        
        return powers.contains(sortedDigits(n));
    }
    
    private String sortedDigits(long num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
