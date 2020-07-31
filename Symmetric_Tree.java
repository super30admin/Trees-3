import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_Tree {
	//Approach: Iterative
	//1. I have used a queue and started pushing the left and right sub trees of the root to check if they are symmetric.
	//2. This repeats as I keep inserting the children of the nodes in the queue, to check for symmetry am inserting the left and corresponding right children of 2 nodes.
	//3. In the same way while inserting right child , am inserting left child of another node thus checking for symmetry throughout the tree. If anywhere the condition fails, we return false.
	public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return true;
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty())
        {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2== null)continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;
            
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }
}
//Time Complexity : O(n) where n is the number of nodes in the tree.
//Space Complexity : O(h) where h is the height of the tree. Since the queue might hold elements equal to the height of the tree at worst case.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: Recursion
//1. Am doing the same process but in recursive steps. Instead of inserting in queue, here am calling the recursive function with left and right children of 2 nodes.
//2. Similarly, the right and left children are also called recursively to check for symmetry.
class Solution{
	
	boolean result ;
    public boolean isSymmetric(TreeNode root) {
        result = true;
        if(root == null)return true;
        helper(root.left, root.right);
        return result;
    }
    private void helper(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)return;   
        if(left == null && right== null)
        {
            result = false;
            return;
        }
        if(left == null || right == null)
        {
            result = false;
            return;
        }
        if(left.val != right.val) 
        {
            result = false;
            return;
        }
        helper(left.left, right.right);
        helper(left.right, right.left);
    }
}

//Time Complexity : O(n) where n is the number of nodes
//Space Complexity : O(log n) or O(h) height of binary tree. (length of recursive stack)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

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