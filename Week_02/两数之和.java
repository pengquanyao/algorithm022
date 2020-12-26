//注意：这个题目返回下标，不能排序
//1、暴力法 两重循环  时间O（n^2）
//2、两遍hash  时间O（n）  空间O（n）  注意点：返回的两个下标不能相同。
//3、一遍hash
class Solution {
//1暴力法
    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

//2 两遍hash  key:数值  value：下标
      public int[] twoSum(int[] nums, int target) {
          int len = nums.length;
          HashMap<Integer, Integer> amap = new HashMap<>(len);
          for(int i = 0; i < nums.length; i++){
              amap.put(nums[i], i);
          }
          for(int i = 0; i < nums.length-1; i++){
              int another = target - nums[i];
              if(amap.containsKey(another)){
                  if(i == amap.get(another)){
                      continue;
                  }
                  return new int[]{i,amap.get(another)};
              }
          }
          return null;
    }

    //3 一遍hash  key:数值  value：下标
      public int[] twoSum3(int[] nums, int target) {
          int len = nums.length;
          HashMap<Integer, Integer> amap = new HashMap<>(len - 1);
          amap.put(nums[0], 0);
          for(int i = 1; i < nums.length; i++){
              int another = target - nums[i];
              if(amap.containsKey(another)){
                  return new int[]{amap.get(another), i};
              }else{
                  amap.put(nums[i], i);
              }
          }
          return null;
    }
}
