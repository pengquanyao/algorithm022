//方法1： dp 时间O(n) 空间O(n)
//方法2： 正序逆序 时间O(n) 空间O(1)
class Solution {
    //方法1
    public int longestValidParentheses1(String s) {
        return 0;
    }

    //方法2
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int left = 0, right = 0;
        int maxLength = 0;
        for(int i = 0; i < n; i++) {
            if(cs[i] == '(') {
                left ++;
            } else {
                right ++;
            }
            if(right > left) {
                right = 0;
                left = 0;
            } else if(right == left){
                maxLength = Math.max(maxLength, right * 2);
            }
        }
        
        right = 0;
        left = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(cs[i] == '(') {
                left ++;
            } else {
                right ++;
            }
            if(right < left) {
                right = 0;
                left = 0;
            } else if(right == left){
                maxLength = Math.max(maxLength, left * 2);
            }
        }
        return maxLength;
    }
}
