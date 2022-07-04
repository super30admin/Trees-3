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
  
    /**
      * Timecomplexity: Have to visit every node + create a copy of list : O(n^2) -> 
      *                                   O(n) for visiting & O(n) time for iterating over eachnode
      *
      *Space complexity : Recursive Stack space +  space for the new arraylist at each node -> O(n^2)
      *
      */
    
      
    private int target = 0;
  
    // Global result
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
                
        // Store it globally so we need not pass around a constant all the time through recursion
        target = targetSum;
        
            
        pathSumHelper(root, 0, new ArrayList<Integer>());
        
        return result;    
    }
    
    //Recursive function to visit every node and calculate sum
    private void pathSumHelper(TreeNode node, int pathSum, List<Integer> path) {
        
        
        if(node == null) return;
        
        
        // Sum till the moment including current node.
        pathSum = pathSum + node.val;
        
        // add current node to the path
        path.add(node.val);
        
        // Base condition
        // Leaf node, add to the result if current sum == target
        if(node.left == null && node.right == null) {
            
            if(pathSum == target) {
                // Since this path adds up to the target put it in the result
                result.add(path);
              //Since we are at the root & the result is found return
              return;
            }
        }
        
        
        // Call the pathSumHelper left and right nodes to get sum from rest of the nodes..
        if(node.left != null)
            pathSumHelper(node.left, pathSum,  new ArrayList<>(path));
        
        if(node.right != null)
            pathSumHelper(node.right, pathSum,  new ArrayList<>(path));
    
    }
    
}
