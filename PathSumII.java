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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        recurr(root, targetSum, output,path,0);
        
        return output;
        
    }
    private void recurr(TreeNode root, int targetSum, List<List<Integer>> output, List<Integer> path, int currSum){
        if(root == null)
            return;
        currSum+= root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                List<Integer> temp = new ArrayList<>(path);
                output.add(temp);
            }
            path.remove(path.size()-1);
            return;
        }
        recurr(root.left, targetSum, output, path, currSum);
        recurr(root.right, targetSum, output, path, currSum);
        path.remove(path.size()-1);
        
    }
}

//TC: O(N*N) N-for all the nodes and N for adding the path to the temp path
//SC: O(N)
