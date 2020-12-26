//默写官方堆解法
class Ugly{
    int[] nums = new int[1691];
    public Ugly() {
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();

        heap.add(1L);
        seen.add(1L);

        Long curr,newNum;
        int[] prim = new int[]{2, 3, 5};

        for(int i = 0; i < 1690; i ++) {
            curr = heap.poll();
            nums[i] = curr.intValue();
        //    System.out.println("i:"+i+" curr:"+curr);
            for(int pr : prim) {
                if(!seen.contains(curr * pr)) {
                   heap.add(curr * pr);
                   seen.add(curr * pr); 
                }
            }
        }
    }
}

class Solution {
    public static Ugly ug = new Ugly();
    public int nthUglyNumber(int n) {
        return ug.nums[n-1];
    }
}
