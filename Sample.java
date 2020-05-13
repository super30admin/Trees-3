import java.util.*;

class Sample {
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
    
    // Time Complexity : O(N) N is number of noded
    // Space Complexity : O(H) H is height of the tree
    // Did this code successfully run on Leetcode : Yes


    // Your code here along with comments explaining your approach
    /*
    1. Maintain list, pathsum  in stack along with tree node.
    2. Each time add node value in list and into path sum. For leaf nodes check if sum is equal to path sum.
    3. At the end remove last element from list to continue to next tree traversal.
    */
     

    private int sum = 0;
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        helper(root, new ArrayList<>(), 0);
        return result;
        
    }
    
    private void helper(TreeNode node, List<Integer> list, int pathSum) {
        
        //Base
        if(node == null)
            return;
        
        //Logic
        pathSum += node.val;
        list.add(node.val);
        if(node.left == null && node.right == null && pathSum == this.sum) {
            result.add(new ArrayList(list)); 
        }
        else {
            helper(node.left, list, pathSum);
            helper(node.right, list, pathSum);
        }
        
        list.remove(list.size()-1);
        
    }

    // Time Complexity : O(N) N is number of noded
    // Space Complexity : O(H) H is height of the tree
    // Did this code successfully run on Leetcode : Yes


    // Your code here along with comments explaining your approach
    /*
    For symmetric tree
    1. left of left child is equal to right of right child
    2. right of left child is equal to left of right child
    */

    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
            return true;
        
        return helper(root.left, root.right);
        
    }
    
    private boolean helper(TreeNode leftNode, TreeNode rightNode) {
        
        //Base
        if(leftNode == null && rightNode == null)
            return true;
        
        if(leftNode == null || rightNode == null)
            return false;
        
        //Logic
        return leftNode.val == rightNode.val 
                && helper(leftNode.left, rightNode.right)
                && helper(leftNode.right, rightNode.left);
        
    }
}