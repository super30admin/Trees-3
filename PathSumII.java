// Approach: Keep track of the current path sum for each node during a preorder traversal. Add the node value to the path and recursively
// traverse the left and right subtrees. When a leaf node is encountered, add its value to the path sum and check if it equals the target
// sum. If it does, print the path. After traversing both subtrees, backtrack by removing the current node from the path.
// Time Complexity: O(n) where n - node count
// Space Complexity: O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/path-sum-ii/description/

import java.util.List;
import java.util.ArrayList;

public class PathSumII {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode (int v) {
            val = v;
        }
    }

    void printRoot2LeafPaths(TreeNode root, int targetSum) {
//        List<Integer> path = new ArrayList<>();
        traverse(root, targetSum, 0, new ArrayList<>());
    }

    void traverse(TreeNode root, int targetSum, int pathSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            pathSum += root.val;
            if (pathSum == targetSum) {
                path.add(root.val);
                System.out.println(path.toString());
                path.remove(path.size() - 1);
            }
            return;
        }
        pathSum += root.val;
        path.add(root.val); // action
        traverse(root.left, targetSum, pathSum, path);
        traverse(root.right, targetSum, pathSum, path);
        path.remove(path.size() - 1); // backtrack - undo action taken earlier
    }

    void cleanerTraverse(TreeNode root, int targetSum, int pathSum, List<Integer> path) {
        if (root == null) {
            return;
        }

        pathSum += root.val;
        path.add(root.val); // Action: Add current node to path

        // If leaf node and path sum matches target, print the path
        if (root.left == null && root.right == null && pathSum == targetSum) {
            System.out.println(path.toString());
        }

        // Recur for left and right subtrees
        traverse(root.left, targetSum, pathSum, path);
        traverse(root.right, targetSum, pathSum, path);

        path.remove(path.size() - 1); // Backtrack: Remove the last added node
    }


    //  TC: O(nlogn) => (n - k) * 1 + k * logn where k - #leaves. max no.of leaves = 2^h for full binary tree and h = logn
//  max no.of nodes in a path for full binary tree is height i.e. logn
    void traverse1(TreeNode root, int targetSum, List<Integer> path) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
//            int pathSum = path.stream().mapToInt(Integer::intValue).sum();
            int pathSum = 0;
            for (int i : path) {
                pathSum += i;
            }
            if (pathSum == targetSum) {
                System.out.println(path.toString());
            }
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            traverse1(root.left, targetSum, path);
        }
        if (root.right != null) {
            traverse1(root.right, targetSum, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII ps2 = new PathSumII();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        ps2.printRoot2LeafPaths(root, targetSum); // prints [[5,4,11,2],[5,8,4,5]]
    }
}