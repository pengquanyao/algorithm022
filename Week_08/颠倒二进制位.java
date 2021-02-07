//方法1  自带函数
//方法2  位运算 
public class Solution {
    //方法1
    public int reverseBits1(int n) {
        return Integer.reverse(n);
    }
    //方法2
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
}
