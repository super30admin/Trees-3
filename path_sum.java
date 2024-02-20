//TC: O(n)
//SC: O(1)
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
    public void helper(TreeNode root, int targetSum, int sum, List<Integer> path)
    {
        if(root==null)
        return;
        sum=sum+root.val;
        path.add(root.val);
        if(root.left==null&&root.right==null)
        {
            if(sum==targetSum)
            {
                result.add(new ArrayList(path));
            }
        
        }

       
        helper(root.left,targetSum,sum,path);
        helper(root.right,targetSum,sum,path);
        path.remove(path.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result=new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>());
        return result;

        
    }
}