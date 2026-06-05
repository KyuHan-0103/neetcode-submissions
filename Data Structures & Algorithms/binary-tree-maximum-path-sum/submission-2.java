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
    int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        /*
        int leftPathMax = temp(root.left);
        int rightPathMax = temp(root.right);
        Math.max(root.val, max);
        */

        return Math.max(temp(root), max);

    }

    public int temp(TreeNode node){
        if(node == null) return 0;

        int left = temp(node.left);
        int right = temp(node.right);

        int pairM = Math.max(left + node.val, Math.max(right + node.val, node.val));
        int sum = left + node.val + right;
        sum = Math.max(pairM, sum);
        max = Math.max(sum, max);
        return pairM;
    }
}
