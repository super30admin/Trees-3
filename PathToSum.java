/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Approach:Using DFS, cover every path from node to leaf
Time Complexity: O(h), h~height of tree
Space Complexity: O(n)
Did the code run on leetcode? Yes
*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, sum, result, path);

        return result;

    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path){
        //Case 1
        if(root==null)
            return;
        path.add(root.val);

        //Case 2
        if(root.left==null && root.right==null){
            if(sum==root.val){
                result.add(new ArrayList<>(path));
                return;
            }
        }

        //Case 3
        if(root.left!=null){
            dfs(root.left, sum-root.val, result, path);

            path.remove(path.size() -1);
        }

        if(root.right!=null){
            dfs(root.right, sum-root.val, result, path);

             path.remove(path.size() -1);

        }

    }


} 