/*
* Approach:
*  1. Apply DFS from the root till we approach leaf node.
* 
*  2. Keep updating the currSum and path during traversal.
    (Remember path is passed as reference, 
        so we have to backtrack our action)
* 
*  3. when we reach leafnode(both left and right are null),
    compare the currSum with targetSum. 

    if equal, add to result using new array of path.
    (because path is passed as reference)

    if its not leaf, recurse on left and right subtrees.

    then backtrack by removing the attached node into path array.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(h)
    height of tree
* 
*/

import java.util.ArrayList;
import java.util.List;

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

public class PathSumII{
    List<List<Integer>> result;

    private void helper(TreeNode root, int currSum, 
            int targetSum, List<Integer> path){
        if(root == null)
            return;

        currSum = currSum + root.val;

        path.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum)
                result.add(new ArrayList<>(path));
        }

        helper(root.left, currSum, targetSum, path);
        
        helper(root.right, currSum, targetSum, path);

        path.remove(path.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        helper(root, 0, targetSum, path);
        
        return result; 
    }
}