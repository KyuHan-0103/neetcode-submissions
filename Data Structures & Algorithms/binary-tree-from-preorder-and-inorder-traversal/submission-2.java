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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode dummy = new TreeNode(0);
        TreeNode cur = dummy;
        int i = 0, j = 0, n = preorder.length;
        while(i < n && j < n){
            cur.right = new TreeNode(preorder[i], null, cur.right);
            cur = cur.right;
            i++;
            while(i < n && cur.val != inorder[j]){
                cur.left = new TreeNode(preorder[i], null, cur);
                cur = cur.left;
                i++;
            }
            j++;
            while(cur.right != null && cur.right.val == inorder[j] && j < n){
                TreeNode prev = cur.right;
                cur.right = null;
                cur = prev;
                j++;
            }
        }
        return dummy.right;
    }
}
