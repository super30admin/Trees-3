// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.targetSum = targetSum;
        helper(root,0,new ArrayList<Integer>());
        return this.result;
    }
    private void helper(TreeNode root,int currSum,List<Integer> path){
        if(root == null) return;
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == this.targetSum){
                this.result.add(new ArrayList(path));
            }
            
        }
        helper(root.left,currSum,path);
        helper(root.right,currSum,path);
        path.remove(path.size()-1);
        
        
    }
}
