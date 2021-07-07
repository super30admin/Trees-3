// Time Complexity : O(n), n is number of nodes
// Space Complexity : O(h), height of tree, worst case O(n) in case of skewed tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Recursive Solution :
class Solution {
    
    //Global variables 
    //res to return null in main and add arraylists (temp) to the result to return, declare here
    //target is set to sum in main and accessed in the helper method
    //alternate would be to send parameter sum to helper each time
    
    List<List<Integer>> res;
    int target;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        //intitialize res in main
        res = new ArrayList<>();
        //set target = sum
        target = sum; 
        //if empty tree, return res (is empty)
        if(root == null) return res;
        
        //call helper function 
        //with tree, cursum as 0, and new arraylist 
        
        return helper(root, 0, new ArrayList<>());
        
    }
    
    //on each recursive call helper in called with next root (child), 
    //sum till the root (parent) and the temp array list with nodes visited 
    private List<List<Integer>> helper(TreeNode root, int cursum, List<Integer> temp) {
        
        //if root == null, return null
        if(root == null) return null;
        
        //cal cursum for the root
        //add the root value to the temp list
        cursum += root.val;    
        temp.add(root.val);
        
        //check if the root is leaf
        //if leaf check is cursum == target
        //if cursum == target, add the temp 
        if(root.left == null && root.right == null) {
             if(cursum == target) {
                 res.add(new ArrayList<>(temp));
             } 
        }
        
        //call helper function for root.left and then root.right
        helper(root.left,cursum, temp);
        helper(root.right, cursum, temp);
       
        //after a value is returned for the helper function, delete the last visited root
        // to avoid printing all nodes in the res
        //as temp is pointing to the final list 
        temp.remove(temp.size()-1);
        
        //return res after completing all helper calls
        return res;
                
    }
}
