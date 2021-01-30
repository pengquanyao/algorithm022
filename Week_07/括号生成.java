//leetcode22
//做题记录
//第1遍 12.28


//1､recursion 暴力枚举法
//2、backtrack
class Solution {
    //1､recursion 暴力枚举法
    public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] curr, int pos, List<String> combinations) {
        if(curr.length == pos){
            if(valid(curr)){
                combinations.add(new String(curr));
            }
            return;
        }

        curr[pos] = '(';
        generateAll(curr, pos + 1, combinations);
        curr[pos] = ')';
        generateAll(curr, pos + 1, combinations);
    }

    public boolean valid(char[] curr){
        int balance = 0;
        for(char c: curr) {
            if(c == '('){
                balance ++;
            } else {
                balance --;
            }

            if(balance < 0){
                return false;
            }
        }
        if(balance == 0){
          return true;
        }
        return false;
    }

    //2､backtrack
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        backTrack(combinations, new StringBuilder(), 0, 0, n);
        return combinations;
    }

    public void backTrack(List<String> combinations, StringBuilder curr, int open, int close, int max) {
        if( curr.length() == max * 2){
            combinations.add(curr.toString());
            return;
        }
        
        if(open < max) {
            curr.append('(');
            backTrack(combinations, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open) {
            curr.append(')');
            backTrack(combinations, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
