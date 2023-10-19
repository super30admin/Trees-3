// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class PathSumTwo {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        List<Integer> path = new ArrayList();
        helper(root,0,targetSum,path);
        return result;
    }
    private void helper(TreeNode root, int currSum, int target, List<Integer> path){

        if(root==null)
            return;
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == target)
                result.add(new ArrayList<>(path));
        }
        helper(root.left,currSum, target, path);
        helper(root.right, currSum, target, path);
        path.remove(path.size()-1);
    }
}