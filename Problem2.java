// Time Complexity : O(n) where n = number of nodes in the tree
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

public class Problem2 {
    
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
    
    private static boolean isSymmetric(TreeNode a, TreeNode b) {
        // If both roots are null, then return true
        // Else if only one of them is null, return false
        if (a == null || b == null) {
            if (a == null && b == null) {
                return true;
            }
            return false;
        }
        // Compare values of roots of both trees
        boolean compareroot = a.val == b.val;
        // Compare left subtree of a with right subtree of b
        boolean comparelefttoright = isSymmetric(a.left, b.right);
        // Compare right subtree of a with left subtree of b
        boolean comparerighttoleft = isSymmetric(a.right, b.left);
        // If roots, left subtrees and right subtrees are all symmetric, return true, else return false
        return compareroot && comparelefttoright && comparerighttoleft;
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
        Integer[] levelarr = {1,2,2,3,4,4,3};
        TreeNode root = makeTree(levelarr);
        // printTree(root);
        boolean res = isSymmetric(root);
        System.out.println(res);
    }

}
