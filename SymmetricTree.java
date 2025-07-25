// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/symmetric-tree/)

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Example 1:
// Input: root = [1,2,2,3,4,4,3]
// Output: true

// Example 2:
// Input: root = [1,2,2,null,3,null,3]
// Output: false
 
// Constraints:
// The number of nodes in the tree is in the range [1, 1000].
// -100 <= Node.val <= 100
 
// Follow up: Could you solve it both recursively and iteratively?

// Definition for a binary tree node.
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

// DFS: Recursive Approach:
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Checking if tree is empty, returning true as empty tree is symmetric
        if (root == null){
            return true;
        }
        
        // Comparing left and right subtrees
        return dfs(root.left, root.right);
    }

    // Recursive helper method to perform DFS comparison between two subtrees
    private boolean dfs(TreeNode left, TreeNode right){

        // if both nodes are null, symmetric at the current level
        if (left == null && null == right){
            return true;
        }

        // if only one of the nodes is null, asymmetric at current level
        if(left == null || right == null){
            return false;
        }

        // if values do not match, asymmetric
        if (left.val != right.val){
            return false;
        }

        // Recursive check: 
        // left subtree of left with right subtree of right
        // right subtree of left with left subtree of right
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}

// BFS (TC: O(n), SC: O(n)): Iterative Approach:
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         // Checking if tree is empty, returning true as empty tree is symmetric
//         if (root == null){
//             return true;
//         }
        
//         // Initializing a Queue to hold pairs of nodes for comparison
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root.left); // Adding first node of left subtree
//         q.add(root.right); // Adding first node of right subtree

//         // Performing BFS to compare nodes in mirror fashion
//         while (!q.isEmpty()){
//             TreeNode left = q.poll(); // Deque one node from the left subtree
//             TreeNode right = q.poll(); // Deque one node from the right subtree

//             // if both nodes are null, symmetric at the current level; continue checking
//             if (left == null && right == null){
//                 continue;
//             }

//             // if only one of the nodes is null, asymmetric detected
//             if (left == null || right == null){
//                 return false;
//             }

//             // if values do not match, tree is asymmetric
//             if (left.val != right.val){
//                 return false;
//             }

//             // Adding children in opposite order to compare mirrored structure:
//             // left's left with right's right, and left's right with right's left
//             q.add(left.left); // Left child of left node
//             q.add(right.right); // Right child of right node

//             q.add(left.right); // Right child of left node
//             q.add(right.left); // Left child of right node
//         }

//         // If all checks are passed, tree is symmetric
//         return true;
//     }
// }