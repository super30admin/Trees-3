import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I perform dfs on the tree and subtract root.val from the targetSum when I traverse through each node and add it to temp List<Integer>.
 * If targetSum = 0, I add the temporary list to the result. I call the helper function recursively on the left child and right child. After both 
 * calls, I backtrack and remove last element from the temp list.
 */


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
class Solution1 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        calculate(root,targetSum,new ArrayList<>());
        return result;
    }

    public void calculate(TreeNode root, int targetSum,List<Integer> temp)
    {
        if(root==null)
        {
            return;
        }
        targetSum-=root.val;
        temp.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(targetSum==0)
            {
                result.add(new ArrayList<>(temp));
            }
        }
        
        calculate(root.left,targetSum,temp);
        calculate(root.right,targetSum,temp);
        temp.remove(temp.size()-1);
    }
}