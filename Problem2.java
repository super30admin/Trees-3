// Time Complexity : O(n)
// Space Complexity :O(h)

class Solution {
    public boolean isSymmetric(TreeNode root) {

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode actual, TreeNode image) {

        if (actual == null && image == null) {
            return true;
        }

        if (actual == null || image == null || actual.val != image.val) {
            return false;
        }

        return isSymmetric(actual.left, image.right) && isSymmetric(actual.right, image.left);

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// class Pair{

// TreeNode actual, image;
// Pair(TreeNode actual, TreeNode image){
// this.actual = actual;
// this.image = image;
// }
// }

// class Solution {
// public boolean isSymmetric(TreeNode root) {

// Stack<Pair> stack = new Stack<>();

// stack.push(new Pair(root.left, root.right));

// while (!stack.isEmpty()){

// Pair p = stack.pop();

// if (p.actual == null && p.image == null){
// continue;
// }

// if (p.actual == null || p.image == null || p.actual.val != p.image.val){
// return false;
// }

// stack.push(new Pair(p.actual.right, p.image.left));
// stack.push(new Pair(p.actual.left, p.image.right));

// }

// return true;

// }
// }