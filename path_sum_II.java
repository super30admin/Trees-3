/**
 * Time Complexity: O(n) n-nodes in the tree
 * Space COmplexity: O(h) h -height of the tree
 */

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
    List<List<Integer>> res = new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        helper(root,0,new ArrayList<>());
        return res;
    }
    public void helper(TreeNode node, int sum, ArrayList<Integer> lst){
        if(node == null) return;

        sum += node.val;
        lst.add(node.val);
        if(node.left == null && node.right==null){
            if(sum == target)
                res.add(new ArrayList<Integer>(lst));
        }
        helper(node.left,sum,lst);
        helper(node.right,sum,lst);
        lst.remove(lst.size()-1);
    }
}