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
    public boolean isBalanced(TreeNode root) {
        TreeNode node = root, last = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> heights = new HashMap<>();
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if(node.right == null || last == node.right){
                    stack.pop();
                    int left = heights.getOrDefault(node.left, 0);
                    int right = heights.getOrDefault(node.right, 0);
                    if(Math.abs(left - right) > 1) return false;

                    heights.put(node, 1 + Math.max(left, right));
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return true;
    }
}
