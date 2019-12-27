// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RootToLeafSum {
    
    int targetSum;
    List<List<Integer>> resultList = new ArrayList<>();
        
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> currentList = new ArrayList<>();
        targetSum = sum;
        helper (root,0,currentList);
        return  resultList;
    }
    
    
    private void helper(TreeNode root, int currentSum, List<Integer> currentList) {
        //base case
        
        if (root == null) return;
        
                currentSum += root.val;
        currentList.add(root.val);
        
        if (root.left == null && root.right == null) {
            if(currentSum == targetSum) {
                resultList.add(currentList);            
            }            
        }

            

        //logic
        helper(root.left,currentSum,new ArrayList<>(currentList));
        helper(root.right,currentSum,new ArrayList<>(currentList));
        
    }
     
}