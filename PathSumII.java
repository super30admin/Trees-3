/**
    L.C: 113. Path Sum II

    Approach: Tree Traversel -> PreOrder with Backtracking

    Working:
        Declare global path - (list) and result -> (list of list)

        dfs(root, 0-> currentSum, target)

            check if root is null
                return;

            //action
            currentSum = currentSum + root.val
            add the root.val to path list

            check if root left and right is null
                if the sum == target
                    add the current path clone to the list

            //recurse
            dfs(root.left, currentSum, target)
            dfs(root.right, currentSum, target)

            //backtrack
            remove the current element i.e the last index in the path list



    Time Complexity = O(n+h) // traversing through all elements, copying elements to new list
    Space Complexity: O(h) max recursive call space


 */


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

    List<Integer> path;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null) {
            return new ArrayList<>();
        }

        path = new ArrayList<>();
        result = new ArrayList<>();

        dfs(root, 0, targetSum);

        return result;

    }

    private void dfs(TreeNode root, int sum, int target) {

        if(root == null) {
            return;
        }
        //action
        sum = sum+root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {

            if(sum == target) {
                result.add(new ArrayList<>(path));
            }
            //if we have the return statement, the current value will not be removed form the list
            //return;

        }

        //recurse
        dfs(root.left, sum, target);
        dfs(root.right, sum, target);

        //backtrack
        path.remove(path.size()-1);
    }
}
