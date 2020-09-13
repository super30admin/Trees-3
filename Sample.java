// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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