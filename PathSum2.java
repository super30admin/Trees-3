// TC = O(N)
// Space Complexity:

// Auxiliary (recursion + path): O(H)

// Output space: O(K * H) where K = number of valid paths

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, targetSum,path,0);
        return result;
    }

    public void helper(TreeNode root, int target, List<Integer> path,int curr){
        if(root == null) return;

        curr += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(curr == target){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left,target,path,curr);
        helper(root.right,target,path,curr);
        path.remove(path.size() -1);
    }
}
