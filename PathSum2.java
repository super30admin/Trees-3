/*
Desc : 
Time Complecity : 
Space Complexity : 
*/


/*class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        helper(root,0,new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path){
        if(root==null){
            return;
        }
        currSum += root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum == target){
                result.add(path);
            }
        }
        helper(root.left,currSum,new ArrayList(path));
        helper(root.right,currSum,new ArrayList(path));
    }
}*/
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        helper(root,0,new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path){
        //action
        if(root==null) return;
        currSum += root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum==target){
                result.add(new ArrayList<>(path));
            }
        }
        //recurse
        helper(root.left,currSum,path);
        helper(root.right,currSum,path);
        //backtrack
        path.remove(path.size()-1);
    }
}
