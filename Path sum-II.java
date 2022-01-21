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

//Time complexity: O(n)
//Space complexity: O(h)
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    int target=0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path=new ArrayList<Integer>();
        target=targetSum;
        helper(root,0,path);
        return res;
    }
    public void helper(TreeNode root, int currSum,List<Integer>path)
    {
        if(root==null)
            return;
    path.add(root.val);
        currSum+=root.val;
        helper(root.left, currSum , path);
        if(root.left==null && root.right==null)
        {
            
            if(currSum==target)
            {
               
               
                res.add(new ArrayList<>(path));
                
                
            }
        }
        helper(root.right, currSum, path);
        path.remove(path.size()-1);
    }
}






