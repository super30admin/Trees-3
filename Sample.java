## Problem2 (https://leetcode.com/problems/symmetric-tree/)

// Time Complexity : 0(h)
// Space Complexity : 0(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1st approach
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
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        isSymmetric = true;
        dfs(root.left, root.right);
        return isSymmetric;        
    }
    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return;
        }
        if (left == null || right == null) {
            isSymmetric = false;
            return;
        }
        if (left.val != right.val) {
            isSymmetric = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}


// 2nd approach-

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return dfs(root.left, root.right);       
    }
    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}


## Problem1 (https://leetcode.com/problems/path-sum-ii/)

// Time Complexity : 0(n^2) because, in the worst-case scenario, we may have to explore all the nodes in the tree and, 
//                   for each node, we perform constant time operations such as adding and removing elements from the path list.
// Space Complexity : 0(n^2) becasue we will have to store all the nodes in the binary tree and the path list for each node.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>());
        return result;        
    }
    private void dfs(TreeNode root, int sum, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == sum) {
                result.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, sum, targetSum, path);
        dfs(root.right, sum, targetSum, path);
        path.remove(path.size() - 1);
    }
}