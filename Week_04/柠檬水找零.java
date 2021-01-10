//leetcode 860
class Solution {
//贪心方法，时间复杂度O(n) 空间复杂度O(1)
    public boolean lemonadeChange(int[] bills) {
        int coin5 = 0;
        int coin10 = 0;
        int coin20 = 0;

        for(int b : bills) {
            if(b == 5) {
                coin5++;
            } else if(b == 10) {
                coin5--;
                coin10++;
                if(coin5 < 0) return false;
            } else {
                if(coin10 > 0) {
                    coin10--;
                    coin5--;
                    if(coin5 < 0) return false;
                } else {
                    coin5 -= 3;
                    if(coin5 < 0) return false;
                }
                coin20++;
            }
        }
        return true;
    }
}
