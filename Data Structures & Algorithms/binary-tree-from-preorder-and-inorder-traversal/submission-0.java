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
    int preIdx;
    int inIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int mid = 0;
        while(inorder[mid] != preorder[0]){
            mid++;
        }

        int[] leftPre = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, mid);
        node.left = buildTree(leftPre, leftIn);

        int[] rightPre = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, mid+1, inorder.length);
        node.right = buildTree(rightPre, rightIn);

        return node;
    }

}
