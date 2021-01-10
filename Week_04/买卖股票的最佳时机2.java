//leetcode 122
class Solution {
    //方法1：贪心  时间O（n）,空间复杂度O(1)
    public int maxProfit1(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }

    //方法2：动态规划 时间O（n）,空间复杂度O(n)
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];

        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max
        }
    }

}
