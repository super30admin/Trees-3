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
}