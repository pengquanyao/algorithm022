//方法1： 排序   创建大数组，再copy小数组
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1,v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;

        for(int[] interval : intervals) {
            if(idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            }  else if(interval[1] > res[idx][1]){
                res[idx][1] = interval[1];
            }
        }

        return Arrays.copyOf(res, idx+1);
    }
}
