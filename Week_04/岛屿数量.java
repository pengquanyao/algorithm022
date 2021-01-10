//leetcode 200
//方法1 dfs递归  时间O(m*n)  空间O(m*n)
//方法2 并查集  时间O(m*n)  空间O(m*n)
class Solution {
    //方法1： dfs  时间O(m*n)  空间O(m*n)
    public int numIslands1(char[][] grid) {
        int row = grid.length;
        if(row == 0) return 0;
        int column = grid[0].length;
        boolean[][] used = new boolean[row][column];

        int res = 0;

        for(int i = 0; i < row; ++i)
            for(int j = 0; j < column; ++j) {
                if(used[i][j] || grid[i][j] == '0') continue;
                
                dfs(grid, row, column, i, j, used);
                res ++;
            }
        return res;
    }

    public void dfs(char[][] grid, int row, int column, int i, int j, boolean[][] used) {
        if(i < 0 || i >= row || j<0 || j >= column || used[i][j] || grid[i][j] == '0') return;
        used[i][j] = true;

        dfs(grid, row, column, i, j+1, used);
        dfs(grid, row, column, i, j-1, used);
        dfs(grid, row, column, i+1, j, used);
        dfs(grid, row, column, i-1, j, used);
    }

    //方法2： 并查集 
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row == 0) return 0;
        int column = grid[0].length;
        int zeroCount = 0;
        UnionFind uf= new UnionFind(row, column);
        for(int i = 0; i < row; ++i)
            for(int j = 0; j < column; ++j) {
                if(grid[i][j] == '0') {
                    zeroCount++;
                    continue;
                }

                if(valid(grid, i + 1, j, row, column)) uf.union(i * column + j, (i + 1) * column + j);
                if(valid(grid, i - 1, j, row, column)) uf.union(i * column + j, (i - 1) * column + j);
                if(valid(grid, i, j + 1, row, column)) uf.union(i * column + j, i * column + j + 1);
                if(valid(grid, i, j - 1, row, column)) uf.union(i * column + j, i * column + j - 1); 
        }
//System.out.println("zeroCount:" + zeroCount);
        return uf.count - zeroCount;
    }

    public boolean valid(char[][] grid, int i, int j, int row, int column) {
        if(i < 0 || i >= row || j<0 || j >= column || grid[i][j] == '0') return false;
        return true;
    }
}

//并查集类
class UnionFind{
    int[] prev;
    int count  = 0;

    public UnionFind(int row, int column) {
        this.prev = new int[row * column];
        this.count = row * column;
        for(int i = 0; i < count; i ++) {
            this.prev[i] = i;
        }
    }

    public void union(int i, int j) {
        int ip = find(i);
        int jp = find(j);
        if(ip == jp) return;

        if(ip < jp) {
            prev[jp] = ip;
        } else {
            prev[ip] = jp;
        }
    //    System.out.println("count:" + count);
        count--;
    }

    public int find(int i) {
        if(i == prev[i]) return i;
        return find(prev[i]);
    }
}
