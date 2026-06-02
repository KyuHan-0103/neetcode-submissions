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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<TreeNode, Integer>(root, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int index = (int) p.getValue();
            TreeNode node = (TreeNode) p.getKey();
            if(index == res.size()){
                res.add(new ArrayList<>());
            }
            res.get(index).add(node.val);

            if(node.left != null){
                q.offer(new Pair<TreeNode, Integer>(node.left, index + 1));
            }
            if(node.right != null){
                q.offer(new Pair<TreeNode, Integer>(node.right, index + 1));
            }
        }
        return res;
    }
}
