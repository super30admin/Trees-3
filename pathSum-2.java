// Time Complexity : O(N) where N=number of nodes
// Space Complexity : O(H) where H=height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
1. Keep adding the current value to the path array and keep going doen.
2. If we're at the last child node and the target is reached then add the current path as one of our answers
3. We then backtrack and remove the elements form the array and go the next node
4. Return the final collection of path array
*/


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> finalList = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<Integer>(), 0);

        return finalList;
    }
    
    public void helper(TreeNode root, int targetSum, List<Integer> currentPath, int currentSum) {
        if(root == null) return;
        
        //Keep adding the current sum
        currentSum += root.val;
        currentPath.add(root.val);

        //If the target is reached and it the lat child node then add the path
        if(currentSum == targetSum) {
            if(root.left == null && root.right == null) {
                finalList.add(new ArrayList<Integer>(currentPath));
                return;
            }
        }
        
        if(root.left != null) {
            helper(root.left, targetSum, currentPath, currentSum);
            if(currentPath.size()>1) currentPath.remove(currentPath.size()-1);
            
        }
        
        if(root.right != null) {
            helper(root.right, targetSum, currentPath, currentSum);       
            if(currentPath.size()>1) currentPath.remove(currentPath.size()-1);
        }
        
        return;
    }
}
