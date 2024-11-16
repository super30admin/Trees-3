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
 // Approach : Using Recursion - Mirror means The value landed from traversing root towarsds left and towards right should be same. Similarly once you are on left sub tree then traversing from left to right should land on same value as you traverse on right sub tree tree from right to left and vice versa. create a helper function that takes left sub tree and right sub tree and do the comparisons.
 // Time : O(n) # visit all the nodes
 // Space : O(h) # recursion space
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // edge case
        if (root == null) return true;

        return helper(root.left, root.right); // left subtree , right subtree
    }

    public boolean helper(TreeNode left, TreeNode right){
        // base case - to stop the comparision
        if(left == null && right == null) return true;

        // logic
        // one side is number and other side not a  number
        if((left == null && right != null) || (right == null && left != null)) return false;
        if(left.val != right.val) return false;

        return helper(left.right, right.left) && helper(left.left,right.right);
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
 // Approach : Iterative solution using stacks. Initially push root twice so you can start the comparison. Build a stack and push  two elements at any given time so we can compare . Until the stack is empty keep pushing and compare the values. At any given time if the values are not equal or one val is null other not null return false. After you come out of the stack return true.
 // Time : O(n) # Traverse the entire input tree once
 // Space : O(n) # worst case no of elements in the stack
 // remove few if loops - improved
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // edge case
        if (root == null) return true;

        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode a = stk.pop();
            TreeNode b = stk.pop();
            if(a == null && b == null) continue;
            if(a == null || b== null) return false;
            if(a.val != b.val) return false;

            stk.push(a.right); // left subtree - move right
            stk.push(b.left); // right subtree - move left

            stk.push(a.left);
            stk.push(b.right); 
        }
        return true;
    }
}