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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int tmp = dfsDiameter(root);
        return res;
    }

    private int dfsDiameter(TreeNode root){
        if(root == null) return 0;
        
        int leftH = dfsDiameter(root.left);
        int rightH = dfsDiameter(root.right);
        res = Math.max(res,
        (leftH + rightH));

        return 1 + Math.max(leftH, rightH);
    }
}
