//关键点：1、判断每列是否有王后  2、判断正斜行是否有王后  3、判断逆斜行是否有王后
//方法1： 递归回溯
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backTrack(ans, queue, n, 0, columns, diagonals1, diagonals2);
        return ans;
    }

    public void backTrack(List<List<String>> ans, int[] queue, int n, int row,
    Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if( n == row) {
            ans.add(geneBroad(queue, n));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(columns.contains(i)) continue;
            int diagonal1 = row - i;
            if(diagonals1.contains(diagonal1)) continue;
            int diagonal2 = row + i; 
            if(diagonals2.contains(diagonal2)) continue;

            queue[row] = i;
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            backTrack(ans, queue, n, row + 1, columns, diagonals1 ,diagonals2);
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    public List<String> geneBroad(int[] queue, int n) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char[] cs = new char[n];
            Arrays.fill(cs, '.');
            cs[queue[i]] = 'Q';
            ret.add(new String(cs));
        }
        return ret;
    }
}
