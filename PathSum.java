// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    List<List<Integer>> finalresult = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root!= null){
          findPath(root, 0 , new ArrayList() ,targetSum);
        }
        return finalresult;
    } 
    
    private void findPath(TreeNode root, int currSum ,List<Integer> path, int targetSum){
        
        if(root == null){
            return;
        }
        
        currSum = currSum + root.val;
        path.add(root.val);
        
        if(currSum == targetSum && root.left == null && root.right == null){
            finalresult.add(path);
            return;
        }
        
        findPath(root.left, currSum , new ArrayList(path) ,targetSum);
        findPath(root.right, currSum ,new ArrayList(path), targetSum);
        
        
    }
}