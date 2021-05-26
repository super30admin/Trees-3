// Time Complexity :O(n), n=number of nodes
// Space Complexity :O(h), h=height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //list to store result
        List<List<Integer>> result = new ArrayList<>();
        //calling helper function to recurse
        helper(root, targetSum, result, new ArrayList<>(), 0);
        return result;

    }
    //helper function
    public void helper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path, int currSum){

        //base
        //root is null
        if(root==null) return;
        //update current sum
        currSum = currSum+root.val;
        //update path
        path.add(root.val);
        //if its a leaf node
        if(root.left == null && root.right==null){
            //if target is reached
            if(currSum==targetSum){
                //update result
                result.add(new ArrayList<>(path));
                //backtrack

            }
            path.remove(path.size()-1);
            return;
        }

        //recurse left and right child
        helper(root.left, targetSum, result, path, currSum);
        helper(root.right, targetSum, result, path, currSum);
        //backtrack
        path.remove(path.size()-1);
    }
}