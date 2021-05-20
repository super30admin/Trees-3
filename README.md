# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
         helper(root,0,targetSum,new ArrayList<>());
         return result;
           
    }
    private void helper(TreeNode root,int currSum, int targetSum,List<Integer> path)
    {
        if(root == null)
        {
          return ;
        }
        currSum += root.val;
        path.add(root.val);
        if(root.right == null && root.left ==null)
        {
            if(currSum==targetSum)
             result.add(path);
        }
           helper(root.left,currSum,targetSum,new ArrayList(path));
           helper(root.right,currSum,targetSum,new ArrayList(path));
       
    }    
        
    
}
TIME Complexity :O(n),n is the total number of elements in the tree
Space Complexity:O(n) 

## Problem2 (https://leetcode.com/problems/symmetric-tree/)
class Solution {
    boolean isvalid;
    public boolean isSymmetric(TreeNode root) {
        isvalid=true;
        helper(root.left,root.right);
        return isvalid;
        
    }
    private void helper(TreeNode left,TreeNode right)
    {
        if(left==null && right==null) return;
        //comparing values of subtres
        if(left==null || right==null ||left.val!=right.val)
        {
            isvalid=false;
            return;
        }
        
        helper(left.left,right.right);
        helper(left.right,right.left);
 }
}
TIME Complexity :O(n),n is the total number of elements in the tree
Space Complexity:O(1) no extra space
