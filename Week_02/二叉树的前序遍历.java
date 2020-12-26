/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //方法一 递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        dohelper(root, result);
        return result;
    }
    
    public void dohelper(TreeNode root, List<Integer> result){
           result.add(root.val);
           if(root.left != null) dohelper(root.left, result);
           if(root.right != null) dohelper(root.right, result);
    }

    //方法2 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> dequeue = new LinkedList<>();

        while(root != null || !dequeue.isEmpty()) {
            if(root == null){
                root = dequeue.pollFirst();
                continue;
            }

            result.add(root.val);
            if(root.right != null ) dequeue.addFirst(root.right);
            if(root.left != null ) dequeue.addFirst(root.left);
            root = dequeue.pollFirst();
        }  
    
        return result;
    }

}
