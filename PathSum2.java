// Time Complexity : O(n) n = number of nodes in tree as we visit each node
// Space Complexity : O(n) n = Length of path list
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach

class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(res, path,root,sum);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if(root==null) return;
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(root.val);
        if(root.left==null && root.right==null && root.val==sum) {
            res.add(newPath);
            return;
        }
        helper(res,newPath,root.left,sum-root.val);
        helper(res,newPath,root.right,sum-root.val);
    }
}