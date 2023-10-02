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
 // Time Complexity: O(n^2) where n times we are calling n copies in array
 //Space Complexity: O(n^2)  
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
        {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        inorder(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void inorder(TreeNode root, int currSum, int targetSum, ArrayList<Integer> path)
    {
        if(root==null)
        {
            return;
        }

        
        
        path.add(root.val);
        inorder(root.left, currSum+root.val, targetSum, new ArrayList<>(path));
        inorder(root.right, currSum+root.val, targetSum, new ArrayList<>(path));
        if(root.left==null && root.right==null)
        {
            if(targetSum == currSum+root.val)
            {
                result.add(path);
            }
        }
    }
}
