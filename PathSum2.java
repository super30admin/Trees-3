// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are traversing across all the nodes in the tree in worst case scenario
//Space Complexity: O(1) since we are not taking any extra space

class Solution {
    
    List<List<Integer>> resultList = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        return helper(root, 0, targetSum, new ArrayList<>());
    }
    
    private List<List<Integer>> helper(TreeNode root, int rSum, int targetSum, List<Integer> path)
    {
        //Base Condition
        if(root == null) return new ArrayList<>();
        
        path.add(root.val);
        rSum = rSum + root.val;
        if(root.left == null && root.right == null && rSum == targetSum){
            resultList.add(new ArrayList(path));
        }
                
        helper(root.left, rSum, targetSum, path);
        helper(root.right, rSum, targetSum, path);
        
        //Backtrack
        path.remove(path.size() - 1);
        
        return resultList;
    }
}