// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> sublist = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preorder(root, sublist, targetSum, 0);
        return result;
    }
    private void preorder(TreeNode root, List<Integer> sublist, int targetSum, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum = sum + root.val;
            if (targetSum == sum) {
                sublist.add(root.val);
                result.add(new ArrayList<>(sublist));
                sublist.remove(sublist.size()-1);
            }
            return;
        }
        sublist.add(root.val);
        sum = sum + root.val;
        preorder(root.left, sublist, targetSum, sum);
        preorder(root.right, sublist, targetSum, sum);
        sublist.remove(sublist.size()-1);
    }
}


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
    boolean isSymmetric = true;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        checkSymmetry(root.left , root.right);
        return isSymmetric;
    }

    private void checkSymmetry(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return;
        }
        if (leftTree == null || rightTree == null ) {
            isSymmetric= false;
            return;
        }

        if(leftTree.val != rightTree.val) {
            isSymmetric = false;
            return;
        }

        if (isSymmetric != false) {
            checkSymmetry(leftTree.left, rightTree.right);
            checkSymmetry(leftTree.right, rightTree.left);
        }


    }
}
