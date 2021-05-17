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

// Time Complexity :  O(N^2) as there is traversal of all nodes in tree and each node we look for path thru leaf.
// Space Complexity : O(N) for new lists created in the pathsum.
// Did this code successfully run on Leetcode : Yes

class PathSumTwo {
    
      List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        int currsum=0;
      
        List<Integer> runningsum= new ArrayList<>();
        helper(root,targetSum,runningsum,currsum); // start with root, currsum 0 and empty runningsumlist
        
        return result;
        
    }
    
    
    public void helper(TreeNode root, int targetsum, List<Integer> runningSum, int currsum){
        
        if(root==null) return;
        
        currsum=currsum+root.val; // compute pathsum
        runningSum.add(root.val); // add root node to runningsum list
        
        if(root.left==null && root.right==null){  // Check if the current node is a leaf 
            if(currsum==targetsum)  //check if current sum equals our remaining sum. If it does, we add the path to
        // our list of paths
            
                result.add(new ArrayList<>(runningSum));
                
        }
        
        else{ // recursively call on left and right subtrees
            helper(root.left,targetsum,new ArrayList<>(runningSum),currsum);
            helper(root.right,targetsum,new ArrayList<>(runningSum),currsum);
        }
        
    }
    
}