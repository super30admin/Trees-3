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



// TC: O(N)
// SC: O(N^2)

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        helper(root, sum, 0, new ArrayList<>());
        
        
        return result;
        
    }
   
    private void helper(TreeNode root, int sum, int currSum, List<Integer> path){
        
        if(root == null){
            return;
        }
        
         int newSum = currSum + root.val;
        
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(newSum == sum){
                result.add(path);
                
            }
        }
        
        helper(root.left, sum, newSum, new ArrayList<>(path));
        helper(root.right, sum, newSum, new ArrayList<>(path));
        
    }
     
    
}





// Backtracking


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



// TC: O(N)
// SC: O(N^2)

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        helper(root, sum, 0, new ArrayList<>());
        
        
        return result;
        
    }
   
    private void helper(TreeNode root, int sum, int currSum, List<Integer> path){
        
        if(root == null){
            return;
        }
        
         int newSum = currSum + root.val;
        
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(newSum == sum){
                result.add(new ArrayList<>(path));
                
            }
        }
        
        helper(root.left, sum, newSum, (path));
        helper(root.right, sum, newSum, (path));
        
        //backrtracking
        path.remove(path.size()-1);
        
    }
    
        
        
    
}