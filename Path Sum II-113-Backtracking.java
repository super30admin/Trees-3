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
 // Time Complexity: O(n) where n times we are calling n copies in array
 //Space Complexity: O(h) where h is the height of the tree
 // Backtracking  
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
        //base
        if(root==null)
        {
            return;
        }
        //logic
        //action
        
        path.add(root.val);
        //Recurse
        inorder(root.left, currSum+root.val, targetSum, path);
        //Backtracking
        if(root.left==null && root.right==null)
        {
            if(targetSum == currSum+root.val)
            {
                result.add(new ArrayList<>(path));
            }
        }
        inorder(root.right, currSum+root.val, targetSum, path);
        path.remove(path.size()-1);
        
    }
}
