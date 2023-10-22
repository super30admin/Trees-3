// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        helper(root,0,targetSum,new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root,int currNum,int targetSum,List<Integer> currPath){
        if(root == null)
            return;
        currNum+=root.val;
        currPath.add(root.val);
        if(root.left == null && root.right==null){
            System.out.println(currNum);
            if(currNum == targetSum)
                res.add(new ArrayList<>(currPath));
        }
        helper(root.left,currNum,targetSum,currPath);
        helper(root.right,currNum,targetSum,currPath);
        currPath.remove(currPath.size()-1);
    }
}