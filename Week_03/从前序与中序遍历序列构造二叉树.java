/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //leetcode 105
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        if( preLength != inLength) return null;

        Map<Integer, Integer> inMap =  new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i ++) {
            inMap.put( inorder[i], i);
        }

        return buildTree(preorder, 0, preLength - 1, inMap, 0, inLength - 1);
    }

    public TreeNode buildTree(int[] preOrder, int preLeft, int preRight, 
                              Map<Integer,Integer> inMap, int inLeft, int inRight){
        if( preLeft > preRight || inLeft > inRight) return null;

        TreeNode node = new TreeNode(preOrder[preLeft]);
        int inP = inMap.get(node.val);

        node.left = buildTree(preOrder, preLeft + 1, preLeft + inP -inLeft, inMap, inLeft, inP-1);
        node.right = buildTree(preOrder, preLeft + inP -inLeft + 1, preRight, inMap, inP + 1, inRight);
        return node;
    }
}
