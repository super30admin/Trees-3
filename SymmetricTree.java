// Time Complexity : O(n)
// Space Complexity : O(h) : h--> height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach1: Recursive solution (DFS)
// Recursive comparison of the leftmost element with rightmost element gives the symmetry of outermost elements
// Once outermost elements are checked, recursive comparisons between innermost elements are done

// Approach1: Iterative solution (DFS)
// In iterative solution, same set of comparisons will be performed. The only difference is that the nodes will be pushed on a stack datastructure.

//Approach3: Iterative Solution (BFS)
// The tree will be traversed level by level. Instead of a stack datastructure, queue datastructure will be used. Each level will be evaluated and result will be returned accordingly.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // Approach1: Recursive solution
        // return checkSymmetry(root, root);
        
        // Approach2: Iterative solution (DFS)
        /*
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
        */
        
        //Approach3: Iterative solution (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if(left == null && right == null) continue;
                if(left == null || right == null || left.val != right.val) return false;
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
        }
        return true;
    }
    
    private boolean checkSymmetry(TreeNode tree1, TreeNode tree2) {
        // base case
        if(tree1 == null && tree2 == null) return true;
        if(tree1 == null || tree2 == null || tree1.val != tree2.val) return false;
        // logic
        return checkSymmetry(tree1.left, tree2.right) && checkSymmetry(tree1.right, tree2.left);
    }
}

