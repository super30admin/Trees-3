/*
Run Time complexity - O(N) - where N is the number of elements in the array
Space Complexity - O(H) if the space required for the output list is not considered, and H could be maximum height of the tree, then H is the stack space required.
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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        backtracking(root,targetSum,new ArrayList<>());
        return result;
    }
    
    public void backtracking(TreeNode root,int sum,List<Integer> res)
    {
        if(root==null)
            return;
        sum=sum-root.val;
        res.add(root.val);
        if(root.left==null && root.right==null)
            if(sum==0)
            {
                result.add(new ArrayList<>(res));
            }
        backtracking(root.left,sum,res); // if we just send the res, then it is a copy by reference, and all the elements just keep appending
        backtracking(root.right,sum,res);
        res.remove(res.size()-1);
    }
    
    
    public void helper(TreeNode root,int sum,List<Integer> res)
    {
        if(root==null)
            return;
        if(sum<0)
            return;
        sum=sum-root.val;
        res.add(root.val);
        if(root.left==null && root.right==null)
            if(sum==0)
            {
                result.add(res);
            }
        helper(root.left,sum,new ArrayList<>(res)); // if we just send the res, then it is a copy by reference, and all the elements just keep appending
        helper(root.right,sum,new ArrayList<>(res));
    }
}   
