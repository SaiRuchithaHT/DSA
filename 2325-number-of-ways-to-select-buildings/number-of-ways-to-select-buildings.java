class Solution {
    public long numberOfWays(String s) {
        // 0 0 0 1 1 0 0 1  0 0
        // one 0 0 0 1 2 2 2 3  3 3
        //  01 0 0 0 3 6 6 6 11 11 11
        // zero 1 2 3 3 3 4 5 5  6 7
        //  10 0 0 0 0 0 2 4 4  7 10
        // ways 0 0 0 0 0 6 12 16 27 38
        long one = 0, zero = 0, oneZero = 0, zeroOne = 0, ways = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++zero;
                oneZero += one; // Count in '10'.
                ways += zeroOne; // Count in '010'.
            }else {
                ++one;
                zeroOne += zero; // Count in '01'.
                ways += oneZero; // Count in '101'.
            }
        }
        return ways;
    }
}