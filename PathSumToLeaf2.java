// Time Complexity : O(n * h) , n for traversing over the nodes and h = height of tree, which will be deep copied at each node
// Space Complexity : O(n * h),  at each node we are storing a list.
//where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Iterate over the tree and keep currSum and path till each node,
// and when we reach target. add path in the result


//Approach 1:

// Your code here along with comments explaining your approach

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
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path) {
        //base
        if (root == null) return;

        //logic
        int value = currSum + root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (value == targetSum) {
                result.add(path);
            }
        }

        helper(root.left, value, targetSum, new ArrayList<>(path));
        helper(root.right, value, targetSum, new ArrayList<>(path));
    }
}


//Approach 2:

// Time Complexity : O(n) , n for traversing over the nodes.
// Space Complexity : O(h) , where h = height of the tree (max recursion calls at one point)/ or the path at leaf node.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english :Used backtracking to save space. 
// Iterate over the tree and keep currSum at each node, and when we reach target add path in the result.
// Remove the node from list, if we have already traversed left and right subtree of it.

// Your code here along with comments explaining your approach

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
        
        helper(root, 0, targetSum,new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum,List<Integer> path) {
        //base
        if (root == null) return;

        //logic
        int value = currSum + root.val;

        //action
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (value == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        //recurse
        helper(root.left, value, targetSum,path);
        helper(root.right, value, targetSum,path);

        // backtrack: remove last element from the list.
        path.remove(path.size()-1);

    }
}
