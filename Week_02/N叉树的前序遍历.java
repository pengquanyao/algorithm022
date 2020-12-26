/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

//方法1 递归 
//方法2 迭代   使用双端队列
class Solution {
    //方法1 递归
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        doPreorder(root, result);
        return result;
    }

    public void doPreorder(Node root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        for(Node node : root.children){
            doPreorder(node, result);
        }
    }

    //方法2 迭代
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> dequeue = new LinkedList<>();

        while(root != null || !dequeue.isEmpty()) {
            if(root == null){
                root = dequeue.pollFirst();
                continue;
            }

            result.add(root.val);
            if(root.children != null && root.children.size() > 0) {
                for(int i= root.children.size()-1; i >= 0; i--){
                    dequeue.addFirst(root.children.get(i));
                }
            }
            root = dequeue.pollFirst();
        }  
    
        return result;
    }
}
