# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)
## Solution 1:
## Time Complexity:O(n) Space Complexity:O(h)
## We use same reference as a list we add the number as a path to the list ones it reaches the leaf node we add it in the result and then remove the last value since it was a leaf node and track back recursively.
## we make a new reference to store the list .
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    this.result=new ArrayList<>();
    helper(root,targetSum,0,new ArrayList<>()) ;
    return result; 
    }


    private void helper(TreeNode root,int targetSum,int currSum,List<Integer> path){

        if(root==null) return;

        currSum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                result.add(new ArrayList<>(path));
            
            }
            
        }
        
        helper(root.left,targetSum,currSum,path);
        
        helper(root.right,targetSum,currSum,path);
        path.remove(path.size()-1);
    }
}
## Problem2 (https://leetcode.com/problems/symmetric-tree/)
## Solution 2
## Time Complexity:O(n) Space Complexity:O(h)
## We check all the edge cases and compare the left node and right node together to see if the left and right subtree matches.
## The value is returned accordingly
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // A tree is symmetric if both sides mirror each other
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode root1, TreeNode root2) {
        // Both nodes are null: symmetric
        if (root1 == null && root2 == null) {
            return true;
        }
        // One node is null, or values don't match: not symmetric
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        // Check if the left subtree of root1 matches the right subtree of root2
        // AND if the right subtree of root1 matches the left subtree of root2
        return compare(root1.left, root2.right) && compare(root1.right, root2.left);
    }
}
