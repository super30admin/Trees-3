// Time Complexity : O(n) where n is number of nodes in the tree as each node should be visited at least once.
// Space Complexity : O(h) where h is height of the tree for the recursive call stack and the path list. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Followed the class tutorial

// Your code here along with comments explaining your approach
// This problem is an extension to the path sum problem as here we have to store the current path as well. We will traverse the tree recursively and maintain the 
// sum and current path of the nodes. When leaf is reached we will check if the running sum is equal to the target or not if it is then we will the path to the 
// result list. After exploring both subtrees left one and right one we will remove the current node from the path to backtrack correctly.

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        // helper(root, 0, targetSum, new ArrayList<>());
        helper(root, 0, targetSum);
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum) {

        if (root == null) {
            return;
        }

        currSum += root.val;
        // List<Integer> copyPath = new ArrayList<>(path);
        // copyPath.add(root.val);
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                // result.add(copyPath);
                List<Integer> copyPath = new ArrayList<>(path);
                result.add(copyPath);
            } 
            // return;
        }

        // helper(root.left, currSum, targetSum, copyPath);
        // helper(root.right, currSum, targetSum, copyPath);

        // helper(root.left, currSum, targetSum, path);
        // helper(root.right, currSum, targetSum, path);

        helper(root.left, currSum, targetSum);
        helper(root.right, currSum, targetSum);

        path.remove(path.size() - 1);
        
    }
}


// Time Complexity : O(n) where n is number of nodes in the tree as each node has to be visited at least once.
// Space Complexity : O(h) where h is the height of the tree for recursive call stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Followed the class tutorial

// Your code here along with comments explaining your approach
// In this approach we will check if the left and right subtrees of the root are mirror images of each other by recursively comparing nodes. The base case will be 
// returning true if both nodes are null and false if one is null or their values do not match. We also need to ensure that left's left subtree matches with right's
// right subtree and left's right subtree matches with right's left subtree. 

import com.sun.source.tree.Tree;

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
        
        // BFS Solution
        // if(root == null) return true;

        // Queue<TreeNode> queue = new LinkedList<>();

        // queue.add(root.left);
        // queue.add(root.right);

        // while(!queue.isEmpty()) {
        //     TreeNode left = queue.poll();
        //     TreeNode right = queue.poll();

        //     if(left == null && right == null) continue;

        //     if(left == null || right == null || left.val != right.val) {
        //         return false;
        //     }

        //     queue.add(left.left);
        //     queue.add(right.right);

        //     queue.add(left.right);
        //     queue.add(right.left);
        // }

        // return true;




        // DFS Solution
        if(root == null) return true;
        
        return dfs(root.left, root.right);

    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;

        if(left == null || right == null || left.val != right.val) return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}