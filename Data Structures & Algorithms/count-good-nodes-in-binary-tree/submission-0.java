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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        //Stores the highest val node for each node
        Map<TreeNode, Integer> map = new HashMap<>();
        int res = 0;
        stack.push(root);
        map.put(root, root.val);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.val >= map.get(node)){
                res++;
                map.put(node, node.val);
            }

            if(node.left != null){
                stack.push(node.left);
                map.put(node.left, map.get(node));
            }
            if(node.right != null){
                stack.push(node.right);
                map.put(node.right, map.get(node));
            }
        }
        return res;
    }
}
