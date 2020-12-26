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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if(root == null){
    //         return new ArrayList<Integer>();
    //     }
    //     List<Integer> result = new ArrayList<>();
    //     result.addAll(inorderTraversal(root.left));
    //     result.add(root.val);
    //             result.addAll(inorderTraversal(root.right));
    //             return result;
    // }

//1､官方递归
//时间复杂度： O（n）, 每个节点遍历一次
//空间复杂度： O（n）， 递归栈所用空间 

    // public List<Integer> inorderTraversal(TreeNode root) {
        
    //     List<Integer> result = new ArrayList<>();
    //     if(root == null){
    //         return result;
    //     }

    //     dohelper(root, result);
    //     return result;
    // }
    
    // public void dohelper(TreeNode root, List<Integer> result){
    //        if(root.left != null) dohelper(root.left, result);
    //        result.add(root.val);
    //        if(root.right != null) dohelper(root.right, result);
    // }

    //2、官方迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack1=new LinkedList<>();

        while(root != null || !stack1.isEmpty()){
            while(root != null){
                stack1.push(root);
                root = root.left;
            }
            root = stack1.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
