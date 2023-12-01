// Time Complexity :O(N)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result= new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>(),result);

        return result;
    }

    public void helper(TreeNode root, int targetSum,int sum,List<Integer> path,List<List<Integer>> result)
    {
        if(root == null)
        return;

        path.add(root.val);
        System.out.println(path);
        sum=sum+root.val;

        if(root.left==null && root.right==null && sum==targetSum)
        result.add(new ArrayList(path));

        helper(root.left,targetSum,sum,path,result);

        helper(root.right,targetSum,sum,path,result);

        path.remove(path.size()-1);
    }
}