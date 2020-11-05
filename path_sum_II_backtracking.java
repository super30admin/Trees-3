// Time Complexity :O(n), where n is the number of node in the tree, (time required to traverse the tree)
// Space Complexity :O(n), where n is the height of the tree (worst case a skwed binary tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain english
//1. we can use inorder traversal to traverse the complete tree. At every node calculate the runningSum and register the path till root
        // node in a single array
//2. If the root is leaf node and the sum is equal to the runningSum, then add the path of the root as a new arrayList in the result
//3. Keep exploring the left and the right subtrees for the complete tree, to find multiple path if there

// Your code here along with comments explaining your approach

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
    //List to return result
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if(root == null) return result;
        target = sum;
        helper(root, 0, new ArrayList<>());
        return result;
    }
    
    private void helper( TreeNode root, int runningSum, List<Integer> path){
        //base
        if(root == null) return;
        
        //logic
        //ACTION
        //register the path till the current node
        path.add(root.val);
        //calculate the runningSum till the current node
        runningSum += root.val;
        
        //add the path to the result if get the sum and the current node id leaf
        if( root.left ==null && root.right ==null && runningSum == target){
            result.add(new ArrayList<>(path));
        }
        //RECURRSION
        //traverse the left subtree with new instance of the path
        helper(root.left, runningSum, path);
        //traverse the right subtree with new instance of the path
        helper(root.right, runningSum, path);
        
        //BACK TRACKING
        //undo last action (remove the last added root)
        path.remove(path.size()-1);
    }
}