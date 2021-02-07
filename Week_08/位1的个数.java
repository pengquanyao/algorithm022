//leetcode191
//方法1 循环和
//方法2 与运算清1
public class Solution {
    //方法1
    public int hammingWeight1(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    //方法2
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n  &= n - 1;
        }
        return res;
    }
}
