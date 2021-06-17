// 113. Path Sum II


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
        result = new ArrayList<>();
        
        if(root == null){
            return result;
        }       
        
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int sum, int curSum, List<Integer> path) {
        if(root == null) {
            return;          
        }

        int newsum = curSum + root.val;
        path.add(root.val);
        helper(root.left, sum, newsum, new ArrayList<Integer>(path));
        if(root.left == null && root.right == null) {
            if(newsum == sum) {
            result.add(path);
            }
        }
        
      //  helper(root.left, sum, newsum, new ArrayList<Integer>(path));
        helper(root.right, sum, newsum, new ArrayList<Integer>(path));
    }
}

/*
Time Complexity: 
O(N*N) where N are the number of nodes in a tree. In the worst case, we could have a complete binary tree and if that is the case, then there would be 
N/2 leafs. For every leaf, we perform a potential O(N) operation of copying over the pathNodes nodes to a new list to be added to the final pathsList. Hence, the complexity in the worst case could be 
O(N*N).

Space Complexity: O(N). 
*/
