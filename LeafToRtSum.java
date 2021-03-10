//Time complexity: O(n)
//Space complexity: O(height of tree)
//Compiled on leetcode.

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
    
    private int t = -1;
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) 
        {
            return result;
        }
        //List<Integer> list = new ArrayList<>();
        t = targetSum;                                  //Taking a list to store and check if root to leaf sum value makes target, if so adding the list to result list.
        totalSum(root, 0);                          //As lists are passed by refernce we need a duplicate list to add the list result.
        return result;                              //  Traversing through each root to leaf possibilities and returning the list that makes target.
    }
    int sum = 0;
   
    
    private void totalSum(TreeNode root, int currSum)
    {
        if(root==null)
            return;
        currSum = currSum+root.val;
        list.add(root.val);
        if(root.left == null && root.right == null)
        {
            
            if(currSum == t)
            {
                List<Integer> temp = new ArrayList<>(list);
                result.add(temp);
            }
            list.remove(list.size()-1);
            return;
        }
        
        totalSum(root.left, currSum);
        totalSum(root.right, currSum);
        
        list.remove(list.size()-1);
    }
}