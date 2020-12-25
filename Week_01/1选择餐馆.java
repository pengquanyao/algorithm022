class Solution {
    public int[] filterRestaurants(int[][] restaurants, int[] filters) {
      List<Integer> result = new ArrayList<>();
      //1、过滤 
      for(int i = 0; i< restaurants.length; i++){
        if(filters[1] >= restaurants[i][3] && filters[2] >= restaurants[i][4]){
          if(filters[0] == 1){
            if(restaurants[i][2] == 1){
              result.add(i);
            }
          }else{
            result.add(i);
          }
        }
      }
      
      int[] resultArray = new int[result.size()];
      for(int i = 0; i < result.size(); i++){
        resultArray[i] = result.get(i);
      }
      
      //2、排序 稳定   rating 从高到低排序。如果 rating 相同，那么按 id 从高到低排序
      // 两遍插入排序， 第一遍排id从高到低，第二遍排rating
      if(resultArray.length <= 1){
        return resultArray;
      }
      
      for(int i = 1; i < resultArray.length; i++){
        for(int j = i-1; j >= 0; j--){
          if(restaurants[resultArray[i]][0] > restaurants[resultArray[j]][0]){
            swap(resultArray, i, j);
          }
        }
      }
      
      for(int i = 1; i < resultArray.length; i++){
        for(int j = i-1; j >= 0; j--){
          if(restaurants[resultArray[i]][1] > restaurants[resultArray[j]][1]){
            swap(resultArray, i, j);
          }
        }
      }
      return resultArray;
    }
  
    void swap(int[] result, int i, int j){
      int temp = result[j];
      result[j] = result[i];
      result[i] = temp;
    }
}

