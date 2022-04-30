// Time Complexity :O(n)
// Space Complexity :(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class PathSum2 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        res = new ArrayList<>();
        dfs(root, targetSum, 0, new ArrayList<>());
        return res;
    }
    
    private void dfs(TreeNode node, int targetSum, int pathSum, List<Integer> path){
        if(node == null) return;
        
        pathSum += node.val;
        List<Integer> curr = new ArrayList<>(path);
        curr.add(node.val);
        if(node.left == null && node.right == null){
            if(pathSum == targetSum) {
                res.add(curr);
                return;
            }
        }
        dfs(node.left, targetSum, pathSum, curr);
        dfs(node.right, targetSum, pathSum, curr);
    }
}
