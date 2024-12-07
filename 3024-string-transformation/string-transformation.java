import java.util.*;

class StringMatcher {
    public List<Integer> kmpSearch(String text, String pattern) {
        int textLength = text.length(), patternLength = pattern.length();
        int[] prefixTable = new int[patternLength];

        // Build the prefix table
        for (int i = 1; i < patternLength; ++i) {
            int j = prefixTable[i - 1];
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = prefixTable[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                prefixTable[i] = j + 1;
            } else {
                prefixTable[i] = 0;
            }
        }

        int matchIndex = 0;
        List<Integer> result = new ArrayList<>();
        
        // Perform KMP search
        for (int i = 0; i < textLength; ++i) {
            while (matchIndex > 0 && text.charAt(i) != pattern.charAt(matchIndex)) {
                matchIndex = prefixTable[matchIndex - 1];
            }
            if (text.charAt(i) == pattern.charAt(matchIndex)) {
                matchIndex++;
            }
            if (matchIndex == patternLength) {
                result.add(i - patternLength + 1);
                matchIndex = prefixTable[matchIndex - 1];
            }
        }

        return result;
    }
}

class Solution {
    private long modularExponentiation(long base, long exponent, int modulus) {
        if (exponent == 0) return 1;
        if ((exponent & 1) == 0) {
            long half = modularExponentiation((base * base) % modulus, exponent >> 1, modulus);
            return half;
        }
        return (base * modularExponentiation((base * base) % modulus, exponent >> 1, modulus)) % modulus;
    }

    public int numberOfWays(String source, String target, long shifts) {
        int length = source.length();
        int MOD = 1_000_000_007;

        // Find cyclic shift positions using KMP
        List<Integer> positions = new StringMatcher().kmpSearch(source + source.substring(0, length - 1), target);
        long[] shiftWays = {0, 0};

        // Calculate ways for shifts
        shiftWays[1] = ((modularExponentiation(length - 1, shifts, MOD) + ((shifts % 2 == 0 ? -1 : 1) + MOD)) % MOD
                * modularExponentiation(length, MOD - 2, MOD)) % MOD;
        shiftWays[0] = (shiftWays[1] - (shifts % 2 == 0 ? -1 : 1) + MOD) % MOD;

        int result = 0;

        // Aggregate results
        for (Integer position : positions) {
            if (position == 0) {
                result = (result + (int) shiftWays[0]) % MOD;
            } else {
                result = (result + (int) shiftWays[1]) % MOD;
            }
        }

        return result;
    }
}
