//Path Sum II
// Time Complexity : O(depth)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        helper(root, new ArrayList(), 0, targetSum);
        return result;
    }
    
    private void helper(TreeNode root,ArrayList<Integer> tempList, int pathSum, int targetSum) {
        if(root == null) {
            return;
        }
        pathSum = pathSum + root.val;
        tempList.add(root.val);
    
        if(root.left == null && root.right == null) {
            if(pathSum == targetSum) {
                result.add(new ArrayList(tempList));
                // System.out.println(tempList);
                tempList.remove(tempList.size()-1);
                return;
            }
        }
        helper(root.left, tempList, pathSum, targetSum);
        helper(root.right, tempList, pathSum, targetSum);
        tempList.remove(tempList.size()-1);
        
    }
}

//Symmteric Tree
// Time Complexity : O(depth)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        preorder(root);
        postorder(root);
        if(postorderList.size() != preorderList.size()) {
            return false;
        }
        for (int i=postorderList.size()-1,j = 0; i>= 0 && j< preorderList.size();i--,j++) {
            if(postorderList.get(i) != preorderList.get(j)) {
                return false;
            }
        }
        return true;
    }
    List<Integer> preorderList = new ArrayList<>();
    List<Integer> postorderList = new ArrayList<>();
   
    private void preorder(TreeNode root) {
        if(root == null) {
            preorderList.add(null);
            return;
        }
        
        preorderList.add(root.val);
        preorder(root.left);
        preorder(root.right);
        
    }
    
     private void postorder(TreeNode root) {
        
        if(root == null) {
            postorderList.add(null);
            return;
        }
        postorder(root.left);
        postorder(root.right);
        postorderList.add(root.val);

    }
    
}