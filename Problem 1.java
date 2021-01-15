//Time Complexity: O(N) where N is the number of nodes in the tree
//Space Complexity: O(h) where h is the height of the tree and if we consider recursive stack space

//Successfully runs on leetcode: 1 ms

//Approach: We perform the sum of each branch of the tree recursively starting from left subtree and then right subtree.
//To maintain the paths that give sum equal to our required target - we are maintaining a path that is local to each node
//of the tree, but in order to update the path that contains the nodes of the path whose sum is not equal to required target,
// we need to remove the nodes from the path and hence, we perform backtracking.


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
import java.util.*;
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if(root == null) return result;
        target = sum;
        helper(root, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path)
    {
        //base
        if(root == null) return;
        
        
        //logic
        currSum += root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null)
        {
            if(currSum == target)
            {
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.left, currSum, path);
        helper(root.right, currSum, path);
        
        path.remove(path.size()-1);
    }
}