// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass Solution {
    int target;
    List<Integer> path;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        path = new ArrayList<>();
        result =new ArrayList<>();
        if(root== null)
        {
            return result;
        }
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int currsum)
    {
        if(root==null)
        {
            return;
        }
        path.add(root.val);
        currsum=currsum+root.val;
        if(root.left== null && root.right== null){
            if(currsum==target){
                result.add(new ArrayList(path));
            }
        }
        helper(root.left,currsum);
        helper(root.right,currsum);
        path.remove(path.size()-1);
    }
}