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
//TC:O(N) SC:O(height of tree)
class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root==null) return resultList;

        helper(root,targetSum,new ArrayList<> (),0);
        return resultList;
    }

    private void helper(TreeNode root, int targetSum,List currentPath,int currentSum){

        if(root == null) return;
        currentPath.add(root.val);
        currentSum+=root.val;
        if(root.left == null && root.right==null)
        {
            if(currentSum == targetSum)
                //    List tempList = new Arraylist(currentPath);
                resultList.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size()-1);
            return;
        }

        helper(root.left,targetSum,currentPath,currentSum);
        helper(root.right,targetSum,currentPath,currentSum);
        currentPath.remove(currentPath.size()-1);

    }
}