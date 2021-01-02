/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //leetcode 236
  //方法1：递归  
 //时间复杂度： O(n)
 //空间复杂度： O(n)

 //方法2： 递归2

 //方法3： 存储父节点
class Solution {
    Map<TreeNode,TreeNode> parentMap =  new HashMap<>();
    Set<TreeNode> pathSet = new HashSet<>();
    private TreeNode res = null;

    //方法1
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return this.res;
    }

    //条件: (frson && flson) || (( x == p || x==q) && (frson || flson))
    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if( node == null) return false;
        boolean rson = dfs(node.right, p, q);
        boolean lson = dfs(node.left, p, q);
        boolean ret = (rson && lson) || ( (node.val == p.val || node.val == q.val) && (rson || lson));
        if(ret) {
            res = node; 
        }
        return rson || lson || (node.val == p.val || node.val == q.val);
    }

        //方法2
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
    
    //方法3
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs1(root);
        buildPath(p);
        return findLCA(q);
    }

    public void dfs1(TreeNode node){
        if(node == null) return;
        if(node.left != null) parentMap.put(node.left, node);
        if(node.right != null) parentMap.put(node.right, node);
        dfs1(node.left);
        dfs1(node.right);
    }
    public void buildPath(TreeNode node){
        while(node != null){
            pathSet.add(node);
            node = parentMap.get(node);
        }
    }

    public TreeNode findLCA(TreeNode node){
        while(node != null){
            if(pathSet.contains(node)){
                return node;
            }
            node = parentMap.get(node);
        }
        return null;
    }
}
