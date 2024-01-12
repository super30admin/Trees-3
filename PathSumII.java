/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PathSumII {
    private List<List<Integer>> result;
    private int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.target = targetSum;
        helper(root,0,new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path) {
        if(root==null) return;
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(currSum == target){
                System.out.println("Path: "+path);
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, currSum, path);
        helper(root.right, currSum, path);
        path.remove(path.size()-1);
    }
}
