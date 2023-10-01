// Leetcode Problem : https://leetcode.com/problems/path-sum-ii/description/
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * If root == null initially, I return the ans as such. Else, I call dfs on root and pass List<List<Integer>> ans, 
 * root, targetSum and temporary list<integer> as the arguments. In the fn, if root==null, I return. I subtract
 * the value of root from targetSum and add root.val to temporary list. I check if root is the leaf node, if yes and if
 * targetSum == 0 , I add the temporary list to the ans. I call the fn recursively on both the left and right child 
 * of root. I then backtrack and remove the last element from the list.
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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        dfs(ans,root,targetSum,new ArrayList<Integer>());
        return ans;
    }

    public void dfs(List<List<Integer>> ans, TreeNode root, int targetSum, List<Integer> temp)
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
                ans.add(new ArrayList<>(temp));
            }
        }
        dfs(ans,root.left,targetSum,temp);
        dfs(ans,root.right,targetSum,temp);
        temp.remove(temp.size()-1);
    }
}