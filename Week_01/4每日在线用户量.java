class Solution {
    public int[] dailyTemperatures(int[] t) {
      int[] result = new int[t.length];
      
      for(int i =  0; i < t.length - 1; i ++){
        int count = 1;
          for(int j = i + 1; j < t.length; j++){
              if(t[i] >= t[j]){
                 count ++;
              }else{
                result[i]=count;
                break;
              }
          }
      }
      
      return result;
    }
}

