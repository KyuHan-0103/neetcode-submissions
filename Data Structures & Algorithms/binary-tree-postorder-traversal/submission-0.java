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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Boolean> visit = new ArrayDeque<>();

        stack.push(root);
        visit.push(false);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            boolean v = visit.pop();
            
            if(cur != null){
                if(v){
                    res.add(cur.val);
                } else {
                    stack.push(cur);
                    visit.push(true);
                    if(cur.right != null){
                        stack.push(cur.right);
                        visit.push(false);
                    }
                    if(cur.left != null){
                        stack.push(cur.left);
                        visit.push(false);
                    }
                }
            }
        }
        return res;
    }
}