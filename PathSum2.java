// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
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
class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();

        result = new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;

        dfs(root, 0);

        return result;
    }

    private void dfs(TreeNode root, int sum) {

        // base
        if (root == null) return;


        // logic
        //action
        path.add(root.val);
        int curSum = sum + root.val;

        //check for leaf node
        if (root.left == null && root.right == null) {
            if (target == curSum) {
                result.add(new ArrayList<>(path));
            }
        }

        // recursive calls
        dfs(root.left, curSum);
        dfs(root.right, curSum);
        path.remove(path.size()-1);
    }

//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         if (root == null) return new ArrayList<>();

//         result = new ArrayList<>();
//         target = targetSum;

//         dfs(root, 0, new ArrayList<>());

//         return result;
//     }

//     private void dfs(TreeNode root, int sum, ArrayList<Integer> path) {

//         // base
//         if (root == null) return;


//         // logic
//         path.add(root.val);
//         int curSum = sum + root.val;

//         //check for leaf node
//         if (root.left == null && root.right == null) {
//             if (target == curSum) {
//                 result.add(path);
//             }
//             return;
//         }

//         // recursive calls
//         dfs(root.left, curSum, new ArrayList<>(path));
//         dfs(root.right, curSum, new ArrayList<>(path));
//     }
}