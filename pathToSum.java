/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 113. Path Sum II
Time Complexity: O(n)
Space Complexity:O(n)
*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, result, path);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path){

        //Case 1: root is null
        if(root == null)
            return;

        path.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == root.val)
                result.add(new ArrayList<>(path));
        }

        //Case 3: left is null
        if(root.right != null){
            dfs(root.right, sum-root.val, result, path);
            path.remove(path.size() - 1);
        }

        //Case 4: right is null
        if(root.left != null){
            dfs(root.left, sum-root.val, result, path);
            path.remove(path.size() - 1);
        }
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> result;
    int sum1 = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        int sum_to_leaf = 0;
        sum1 = sum;

        List<Integer> path = new ArrayList<>();
        helper(root, path, sum_to_leaf);
        return result;
    }

    private void helper(TreeNode root, List<Integer> path, int sum_to_leaf){
        if(root == null)
            return;

        path.add(root.val);
        sum_to_leaf += root.val;

        if(root.right == null && root.left == null){
            if(sum_to_leaf == sum1)
                result.add(path);
        }

        helper(root.right, new ArrayList<>(path), sum_to_leaf);
        helper(root.left, new ArrayList<>(path), sum_to_leaf);
        return;
    }
}


