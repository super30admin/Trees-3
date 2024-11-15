import java.util.ArrayList;
import java.util.List;

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
class Problem1 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<Integer>(), targetSum);
        return result;
    }
//     private void helper(TreeNode root, int currSum, List<Integer> path, int target){
//         // base
//         if(root == null) return;

//         // logic
//         currSum += root.val;
//         List<Integer> currPath = new ArrayList<>(path);
//         currPath.add(root.val);
//         if(root.left == null && root.right == null){
//             if(currSum == target){
//                 result.add(currPath);
//             }
//         }
//         helper(root.left, currSum, currPath, target);
//         helper(root.right, currSum, currPath, target);
//     }
    private void helper(TreeNode root, int currSum, List<Integer> path, int target){
        // base
        if(root == null) return;

        // logic
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, currSum, path, target);

        helper(root.right, currSum, path, target);

        path.remove(path.size()-1);
    }
}