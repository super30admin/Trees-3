// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        helper(root,sum,currPath,allPaths);
        return allPaths;
    }
    
    private void helper(TreeNode root,int sum, List<Integer> currPath, List<List<Integer>> allPaths){
       if(root==null)return;
        currPath.add(root.val);
        if(root.left==null && root.right==null && root.val==sum){
            allPaths.add(new ArrayList<>(currPath));
        }
        else{
            helper(root.left,sum-root.val,currPath,allPaths);
            helper(root.right,sum-root.val,currPath,allPaths);
        }
        currPath.remove(currPath.size()-1);
    }
}