//TC: O(n)
//SC:height of tree O(h)
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
class Solution1 {
      List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        helper(root,targetSum,0,new ArrayList<Integer>());
        return result;
    }
    private void helper(TreeNode root,int targetSum,int currSum,List<Integer> path)
    {
        //base case
        if(root==null)
        {
            return;
        }
        //logic
        currSum+=root.val;
        path.add(root.val);

        //Action
        if(root.left==null && root.right==null)//we reach at leaft node so calculate the sum of paths from root to leaf
        {
            if(targetSum==currSum)
            {
                //action
                result.add(new ArrayList<>(path));
            }
        }
        //recurse
        helper(root.left,targetSum,currSum,path);//passing deep copy instead of actual reference
        helper(root.right,targetSum,currSum,path);
        //backtracking (undo action)
        path.remove(path.size()-1);//remove last element from path

    }
}