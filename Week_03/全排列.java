//方法1：dfs 深度优先搜索  状态回溯
 //时间复杂度：
 //空间复杂度：

  //方法2：bfs 广度优先搜索 
 //时间复杂度：
 //空间复杂度：
class Solution {
    //方法1
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res =  new ArrayList<>();
        //栈
        Deque<Integer> path =  new LinkedList<>();
        boolean[] flag = new boolean[nums.length];

        dfs(nums, path, flag, res);
        return res;
    }

    public void dfs(int[] nums, Deque<Integer> path, boolean[] flag, List<List<Integer>> res) {
        if(path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(flag[i]) continue;
            path.addLast(nums[i]);
            flag[i] = true;
            dfs(nums, path, flag, res);
            path.removeLast();
            flag[i] = false;
        }
    }

//方法2
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =  new ArrayList<>();
        BfsNode node = new BfsNode(nums, new ArrayList());
        bfs(node, res);
        return res;
    }

    public void bfs(BfsNode node, List<List<Integer>> res) {
        if(node.path.size() == node.nums.length) {
            res.add(node.path);
            return;
        }

        for(int i = 0; i < node.nums.length; i++){
            if(node.flag[i])continue;

            List newPath = new ArrayList(node.path);
            newPath.add(node.nums[i]);
            BfsNode newNode = new BfsNode(node.nums, newPath);

            System.arraycopy(node.flag, 0, newNode.flag, 0, node.nums.length);
            newNode.flag[i] = true;
            bfs(newNode, res);
        }
    }
}

class BfsNode{
    int[] nums;
    boolean[] flag;
    List<Integer> path;
    
    public BfsNode(int[] nums, List<Integer> path) {
        this.nums = nums;
        this.path = path;
        flag = new boolean[nums.length];
    }
}
