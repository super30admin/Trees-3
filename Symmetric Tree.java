/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Note:
Bonus points if you could solve it both recursively and iteratively.
*/

//Recursive Solution: Beats 100 % of LeetCode Submissions

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
        
        if(root == null)    return true;
        
        return  checkSym(root.left, root.right);
    }
    
    boolean checkSym(TreeNode left, TreeNode right){
        
        if(left == null && right == null)
            return true;
        else if(left == null || right == null)
            return false;
        
        if(left.val != right.val)   return false;
        
        return checkSym(left.left, right.right) && checkSym(left.right, right.left);
    }
}



//Iterative Solution using Stack
//Beats 40% of LeetCode Submissions


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
        
        if(root == null)    return true;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode n1, n2;
        stack.push(root.right);
        stack.push(root.left);
        
        while(!stack.isEmpty()){
        
            n1 = stack.pop();
            n2 = stack.pop();
            
            if (n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null || n1.val != n2.val)    return false;
            
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        
        return true;
    }
}