// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.*;
import java.io.*;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class BinaryTree {
	TreeNode root;

    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }
    
    public boolean helper(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
    public static void main(String[] args) {
    		BinaryTree tree = new BinaryTree(); 
        tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(2); 
        tree.root.left.left = new TreeNode(3); 
        tree.root.left.right = new TreeNode(4); 
        tree.root.right.left = new TreeNode(4); 
        tree.root.right.right = new TreeNode(3); 
        boolean output = tree.isSymmetric(tree.root); 
        if (output == true) 
            System.out.println("True"); 
        else
            System.out.println("False"); 
      
    }
}