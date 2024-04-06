
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

// BFS Solution

/*
 * class Solution {
 * public boolean isSymmetric(TreeNode root) {
 * //Tc: O(n) Sc: O(n)
 * if (root == null) {
 * return true;
 * }
 * 
 * Queue<TreeNode> queue = new LinkedList<>();
 * queue.add(root);
 * queue.add(root);
 * 
 * while (!queue.isEmpty()) {
 * TreeNode node1 = queue.poll();
 * TreeNode node2 = queue.poll();
 * 
 * if (node1 == null && node2 == null) {
 * continue;
 * }
 * 
 * if (node1 == null || node2 == null) {
 * return false;
 * }
 * 
 * if (node1.val != node2.val) {
 * return false;
 * }
 * 
 * queue.add(node1.left);
 * queue.add(node2.right);
 * queue.add(node1.right);
 * queue.add(node2.left);
 * }
 * 
 * return true;
 * 
 * }
 * }
 * 
 */

// DFS Solution
/*
 * class Solution {
 * //Tc: O(n) Sc: O(n)
 * public boolean isSymmetric(TreeNode root) {
 * return isTrue(root, root);
 * 
 * }
 * 
 * public boolean isTrue(TreeNode tree1, TreeNode tree2)
 * {
 * if(tree1 == null && tree2 == null) return true;
 * if(tree1 == null || tree2 == null) return false;
 * 
 * return (tree1.val == tree2.val) && isTrue(tree1.left, tree2.right)
 * && isTrue(tree1.right, tree2.left);
 * }
 * }
 * 
 */