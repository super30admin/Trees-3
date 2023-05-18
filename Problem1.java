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

//  Time: O(n) number fof nodes in worst case
// Space: O(h) height of Tree
class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        inorder(root,targetSum,0 , list);
        return res;
    }

    public void inorder(TreeNode node,int target, int cursum, List<Integer> list){
        //base
        if(node == null) return;
        //condition
        cursum = cursum + node.val;
        //action
        list.add(node.val);
        if(node.left == null && node.right == null && cursum == target){
            res.add(list);
        }
        inorder(node.left,target, cursum, list);
        inorder(node.right,target, cursum, list);
        
        // undo the action (backtracking)
        list.remove(list.size()-1);
    }
}