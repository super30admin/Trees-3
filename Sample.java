// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach

class Solution {
    
    List<List<Integer>> result; 
    int currSum = 0; 
    int target; 
    List<Integer> path;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<>();
        path = new ArrayList<>(); 
        target = targetSum; 
        helper(root,currSum);  
        return result; 
    }
    
    private void helper(TreeNode root, int currSum)
    {
        
        //base
        if(root == null) return;
        
        //action
        currSum = currSum + root.val; 
        path.add(root.val);
        
        //logic
        helper(root.left, currSum);
        
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(new ArrayList<>(path)); 
            }
        }
        
        helper(root.right, currSum); 
        
        //backtrack
        currSum = currSum - root.val; 
        path.remove(path.size()-1); 
        
    }
}