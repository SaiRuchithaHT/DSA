class Solution {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean ans;
        if (j == p.length()) {
            ans = (i == s.length());
        } else {
            boolean first_match = (i < s.length() &&
                                   (p.charAt(j) == s.charAt(i) ||
                                    p.charAt(j) == '.'));

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                boolean choice1 = dp(i, j + 2, s, p);
                boolean choice2 = first_match && dp(i + 1, j, s, p);
                ans = choice1 || choice2;
            } else {
                ans = first_match && dp(i + 1, j + 1, s, p);
            }
        }

        memo[i][j] = ans;
        return ans;
    }
}