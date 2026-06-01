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
    public boolean isSameTree(TreeNode p, TreeNode q) {
            Deque<TreeNode[]> stack = new ArrayDeque<>();
            stack.push(new TreeNode[]{p, q});
            while(!stack.isEmpty()){
                TreeNode[] nodes = stack.pop();
                if(nodes[0] == null && nodes[1] == null) continue;
                if(nodes[0] == null || nodes[1] == null || 
                nodes[0].val != nodes[1].val){
                    return false;
                } else {
                    stack.push(new TreeNode[]{nodes[0].left, nodes[1].left});
                    stack.push(new TreeNode[]{nodes[0].right, nodes[1].right});
                }
            }
            return true;
    }
}
