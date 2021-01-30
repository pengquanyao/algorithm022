class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int[] minStep = new int[]{Integer.MAX_VALUE};
        List<String> path = new ArrayList<>();
       // List<String> res = new ArrayList<>();
      // path.add(start);
        bfs(path, minStep, start, end, bank);
        return minStep[0] == Integer.MAX_VALUE? -1:minStep[0];
     //   return res.size();
    }

    public void bfs(List<String> path, int[] minStep, String start, String end, String[] bank) {
      //  System.out.println("start:"+ start + " end:" + end + " path.size:" + path.size());
        if(start.equals(end)) {
     //       System.out.println("start:"+ start + " end:" + end + " path.size:" + path.size());
     //       printSet(path);
            minStep[0] = Math.min(path.size(), minStep[0]);
            return;
        }

        for(String b: bank) {
            if(path.contains(b)) continue;
            int diff = 0;
            for(int i = 0; i < start.length(); i++) {
              //  if(diff > 1) break;
                if(start.charAt(i) != b.charAt(i)) diff++;
            }
            if(diff == 1) {
                path.add(b);
       //         System.out.println(" path.size:" + path.size() + " b:" + b);
                bfs(path, minStep, b, end, bank);
              //  System.out.println(" res.size:" + res.size());
                path.remove(b);
            }
        }
    }

    public void printSet(List<String> path) {
        for(String s:path){
            System.out.print(s+" ");
        }
    }
}
