// Time Complexity : O(n2) where n = number of nodes in the tree
// Space Complexity : O(n) where n = number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Problem1 {
    
    private static List<List<Integer>> ans = new ArrayList<>();
    
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> currpath = new ArrayList<>();
        pathSum(root, targetSum, currpath, 0);
        return ans;
    }
    
    private static void pathSum(TreeNode root, int targetSum, List<Integer> currpath, int currsum) {
        if (root == null) {
            return;
        }
        // Add present node to the current path
        currpath.add(root.val);
        // Add value of the present node to the current sum
        currsum += root.val;
        if (root.left == null && root.right == null) {
            // If currsum is equal to targetsum
            if (currsum == targetSum) {
                // Create a new list with values as current path and add it to ans
                ans.add(new ArrayList<>(currpath));
            } 
        }
        // Recursively call the function for the left subtree
        pathSum(root.left, targetSum, currpath, currsum);
        // Recursively calll the function for the right subtree
        pathSum(root.right, targetSum, currpath, currsum);
        // Remove the last node from the current path
        currpath.remove(currpath.size()-1);
    }

    public static TreeNode makeTree(Integer[] arr) {
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                nodes[i] = new TreeNode(arr[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                int left = 2*i+1 - 2*count;
                if (left >= nodes.length) {
                    break;
                }
                nodes[i].left = nodes[left];

                int right = left+1;
                if (right >= nodes.length) {
                    break;
                }
                nodes[i].right = nodes[right];
            } else {
                count++;
            }
        }
        return nodes[0];
    }

    // Function to print the binary tree
    public static void printTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
          return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                res.add(null);      
            } else {
                q.add(curr.left);
                q.add(curr.right);
                res.add(curr.val);
          }
        }
        int i = res.size()-1;
        while (res.get(i) == null) {
            res.remove(i--);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Integer[] levelarr = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = makeTree(levelarr);
        int targetSum = 22;
        // printTree(root);
        List<List<Integer>> res = pathSum(root, targetSum);
        System.out.println(res);
    }

}
