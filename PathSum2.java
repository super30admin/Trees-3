// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: backtrack to last node which has the right sum till that node

public class PathSum2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;

        DFS(root, targetSum, 0, new ArrayList<>());
        return res;
    }
    private void DFS(TreeNode root, int target, int currSum, List<Integer> path){
        if(root == null) return;

        // action
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && target == currSum){
            res.add(new ArrayList<>(path));
        }

        DFS(root.left, target, currSum, path);
        DFS(root.right, target, currSum, path);

        // backtrack
        path.remove(path.size()-1);
    }
}
