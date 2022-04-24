// we no need to pass the path every iteration we can make it class variable
// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        if(root == null) {
            return result;
        }
        helper(root, 0, targetSum);
        return result;
    }
    private void helper(TreeNode root, int curSum, int targetSum) {
        
        if(root == null){
            return;
        }       
        curSum = curSum + root.val;
        
        //action 
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(curSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        
        //recurse
        helper(root.left, curSum, targetSum);
        helper(root.right, curSum, targetSum);
        
        //backtrack
        path.remove(path.size() - 1);
    }
}