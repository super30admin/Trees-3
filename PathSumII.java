// Time Complexity :O(max(n,c*maxdepth))
// Space Complexity : O(maxdepth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Just like Path sum, traverse to the depth of the node by keeping a sum of elements so far covered along with the List of Path we traverse.
// If the sum is equal to our current sum, then add it to out output list and return, else go on sesrch for the sum.
// we should remove the elements from the current path at the end if we don't find our sum as we don't need them in our currPath list.
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        recurr(root,0,sum,currPath,output);
        return output;

    }

    private void recurr(TreeNode root, int currPathSum, int target, List<Integer> currPath, List<List<Integer>> output){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){

            if(currPathSum+root.val == target){
                List<Integer> temp = new ArrayList(currPath);
                temp.add(root.val);
                output.add(temp);
            }
            return;
        }
        currPath.add(root.val);
        recurr(root.left,currPathSum+root.val,target,currPath,output);
        recurr(root.right,currPathSum+root.val,target,currPath,output);

        currPath.remove(currPath.size()-1);

    }
}