//leetcode#70
class Solution {
    // public int climbStairs(int n) {
    //     int a1 = 1;
    //     int a2 = 2;
        
    //     if(n == 1){
    //         return a1;
    //     }
    //     if(n == 2){
    //         return a2;
    //     }

    //     for(int i = 3; i <= n - 1; i++){
    //         int temp = a1 + a2;
    //         a1 = a2;
    //         a2 = temp;
    //     }

    //     return a1 + a2;
    // }

//方法2 记忆搜索
      public int climbStairs2(int n) {
        int[] mem = new int[n+1];
        return _climbStairs(n,mem);
      }

      public int _climbStairs(int n, int[] mem) {
        if(mem[n] != 0)return mem[n];

        if(n == 1){
            mem[n] = 1;
        }else if(n == 2){
            mem[n] = 2;
        }else{
            mem[n] =  _climbStairs(n - 1,mem) + _climbStairs(n - 2,mem);
        }
        return mem[n];
    }
    //方法3  递推
    public int climbStairs(int n) {
        int p1 = 1;
        int p2 = 2;
        if(n == 1) return p1;
        if(n == 2) return p2;

        for(int i = 3; i <= n; i++) {
            int p3 = p1 + p2;
            p1 = p2;
            p2 = p3;
        }
        return p2;
    }
}
