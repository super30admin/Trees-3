//TC:O(n^2)
//SC:O(height*diameter)
//Successfully ran on leetcode
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        List<List<Integer>> output=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        helper(root,targetSum,0,output,path);

        return output;
    }
    private void helper(TreeNode root,int target,int currSum,List<List<Integer>> output,List<Integer> path)
    {
        if(root==null)
        {
            return;
        }
        currSum+=root.val;
        path.add(root.val);

        if(root.left==null && root.right==null)
        {
            if(currSum==target)
            {

                output.add(new ArrayList<>(path));
            }
            path.remove(path.size()-1);
            return;
        }
        helper(root.left,target,currSum,output,path);
        helper(root.right,target,currSum,output,path);

        path.remove(path.size()-1);
    }
}
