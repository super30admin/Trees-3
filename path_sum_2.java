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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res = res;
        helper(root,0,new ArrayList<>(),targetSum);
        return res;
    }
    public void helper(TreeNode root,int sum,List<Integer>path,int targetSum)
    {
        if(root == null)
        {
            return;
        }
        sum=sum+root.val;

        List<Integer> li = new ArrayList<>(path);
        li.add(root.val);

        helper(root.left,sum,li,targetSum);
        helper(root.right,sum,li,targetSum);
        if(root.left == null && root.right ==null && sum==targetSum)
        {
            res.add(li);

        }
    }
}