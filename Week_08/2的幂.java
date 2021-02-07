class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE) {
            return false;
        }
        n &= n - 1;
        return n == 0;
    }
}
