// Time Complexity : O(n) traverses through all nodes of tree
// Space Complexity : O(n + h) in worst case as we will create h new lists
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        inorder(root, 0, targetSum, new ArrayList<>());

        return result;
    }

    public void inorder(TreeNode root, int currSum, int targetSum, List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);
        inorder(root.left, currSum + root.val, targetSum, path);
        if(root.left == null && root.right == null){
            if(currSum + root.val == targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        inorder(root.right, currSum + root.val, targetSum, path);
        path.remove(path.size() - 1);
    }
}
