// Time Complexity : O(n ^ h)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<>();
        if(root == null)    return result;
        
        find(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    public void find(TreeNode root, int currSum, List<Integer> path, int target){
        
        
        if(root == null)    return;
        
        currSum += root.val;
        
        path.add(root.val); //Adding node value in currern path
        
        find(root.left, currSum, new ArrayList<>(path), target); //Calling left recursive call and sending new copy of path
        
        //STACK.POP() HAPPENED HERE
        
        if(root.left == null && root.right == null){ //When reaching at Leaf node - Check sum is target or not
            if(currSum == target){
                result.add(path);//Add path into result list
                return;
            }
        }
        
        find(root.right, currSum, new ArrayList<>(path), target);//Calling left recursive call and sending new copy of path
    }
}

