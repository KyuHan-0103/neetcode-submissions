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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode cur = root;
        do{

            if(val > cur.val){
                if(cur.right == null){
                    TreeNode n = new TreeNode(val);
                    cur.right = n;
                    return root;
                } else{
                    cur = cur.right;
                }
            } else {
                if(cur.left == null){
                    TreeNode n = new TreeNode(val);
                    cur.left = n;
                    return root;
                } else {
                    cur = cur.left;
                }
            }
        } while (cur.left != null || cur.right != null);
        if(val > cur.val){
            cur.right = new TreeNode(val);
        } else {
            cur.left = new TreeNode(val);
        }
        return root;
    }
}