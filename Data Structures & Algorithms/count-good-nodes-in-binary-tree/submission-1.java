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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int max){
        if(node == null) return 0;
        int m = max;
        if(node.val >= m){
            res++;
            m = node.val;
        }
        dfs(node.left, m);
        dfs(node.right, m);

        return res;
    }
}
