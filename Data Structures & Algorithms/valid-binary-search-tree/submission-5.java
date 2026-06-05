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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, List<Long>> map = new HashMap<>();
        stack.push(root);
        map.put(root, new ArrayList<>(List.of(min, max)));
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node.left != null){
                if(node.val <= node.left.val ||
                node.left.val <= map.get(node).get(0)) return false;
                map.put(node.left,
                new ArrayList<>(List.of(map.get(node).get(0), Math.min(node.val, map.get(node).get(1)))));
                stack.push(node.left);
            }
            if(node.right != null){
                if(node.val >= node.right.val ||
                node.right.val >= map.get(node).get(1)) return false;
                map.put(node.right,
                new ArrayList<>(List.of(Math.max(node.val, map.get(node).get(0)), map.get(node).get(1))));
                stack.push(node.right);
            }
        }
        return true;
    }
}