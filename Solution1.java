// Time complexity: O(N), where N is the number of nodes in the tree. 
// Space complexity: O(d), where d is the maximum depth of the tree.

import java.util.*;

class Solution1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
  
    List<List<Integer>> output = new ArrayList<>(); 

    public void pathSum(TreeNode root, int targetSum, List<Integer> list) {
        // if leaf node
        if (root.left == null && root.right == null) {
            // if targetSum is reached, copy list to output;
            if (targetSum == 0)
                output.add(new ArrayList<>(list));
            return;
        }
        if (root.left != null) {
            // add left node to list
            list.add(root.left.val);
            // update the targetsum
            pathSum(root.left, targetSum - root.left.val, list);
            // remove left node from list
            list.remove(list.size()-1); 
        }
        if (root.right != null) {
            // add right node to list
            list.add(root.right.val);
            // update the targetsum
            pathSum(root.right, targetSum - root.right.val, list);
            // remove right node from list
            list.remove(list.size()-1); 
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // null check for root
        if(root == null) return output; 
        pathSum(root, targetSum-root.val, new ArrayList<Integer>(Arrays.asList(root.val))); 
        return output;
    }
}