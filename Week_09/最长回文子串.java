class Solution {
    //方法1：暴力法 时间O(N^3)
    public String longestPalindrome1(String s) {
        char[] cs = s.toCharArray();
        int resLeft = 0;
        int max = 1;
        for(int i = 0; i < cs.length - 1; i++) {
            for (int j = i + 1; j < cs.length; j++) {
                if( j - i + 1 > max && valid(cs, i, j)) {
                        max = j -i + 1;
                        resLeft = i;
                }
            }
        }
        return s.substring(resLeft, resLeft + max);
    }

    public boolean valid(char[] cs, int i, int j) {
        while(j > i) {
            if(cs[i] != cs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //方法2：动态规划 时间O(N^2)
    public String longestPalindrome2(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[n][n];

        int left = 0;
        int max = 1;

        for(int i = 0; i < n ; ++i) {
            dp[i][i] = true;
        }

        for(int j = 1; j < n; ++ j)
            for(int i = 0; i < n; ++i) {
                if( j > i) {
                    if(j -i +1 <3) {
                        dp[i][j] = (cs[i] == cs[j]);
                    }else if(j - i + 1 >= 3) {
                        dp[i][j] = (cs[i] == cs[j]) && dp[i + 1][j - 1];
                    }

                    if(dp[i][j] && j - i + 1 > max){
                        left = i;
                        max = j - i + 1;
                    }
                }
            }
        return s.substring(left, left + max);
    }

    //方法3：中心扩散 时间O(N^2)
    public String longestPalindrome2(String s) {
    }
}
