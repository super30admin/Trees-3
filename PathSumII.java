import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
 }
 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path)
    {
        //base
        if(root == null) return;

        //action
        currSum += root.val;
        path.add(root.val); //[all nodes]

        if(root.left == null && root.right == null)
        {
            if(currSum == targetSum)
            {
                result.add(new ArrayList<>(path)); // create a deep copy at every node.
            }
        }
        //recursion
        helper(root.left, currSum, targetSum, (path)); 
        helper(root.right, currSum, targetSum, (path));

        //backtracking
        path.remove(path.size()-1);
    }
}