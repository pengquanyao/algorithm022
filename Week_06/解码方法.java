//leetcode#91. 解码方法
//方法1： 动态规划    f(i) = f(i-1)*boolean + f(i-2)*boolean
class Solution {
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];

        dp[0] = check(cs[0]) ? 1 : 0;

        for(int i = 1; i < n; i++) {
            int next = 0;
            if(dp[i - 1] !=0 && check(cs[i])) {
                    next = dp[i - 1];
            }
            
            if(i == 1) {    
                dp[i] = next + (check(cs[i - 1], cs[i])? 1 : 0);
                continue;
            }
            
            int doubleNext = 0;
            if(dp[i - 2] != 0 && check(cs[i - 1], cs[i])) {
                doubleNext = dp[i - 2];
            }
            dp[i] = next + doubleNext;
        }
        return dp[n - 1];
    }

    boolean check(char high, char low) {
        if(high != '1' && high != '2') return false;
        if(high == '2' && low > '6') return false;
        return true;
    }

    boolean check(char c) {
        return c != '0';
    }
}
