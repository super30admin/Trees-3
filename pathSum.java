// Time Complexity : O(n+m)  where n are nodes and m is edges
// Space Complexity : O(d)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
REcursion

class Solution {
     public class TreeNode {
             int val;
             TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
         }
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        helper(root,sum,new ArrayList<Integer>());
        return output;
    }
    private void helper(TreeNode root, int sum, List temp)
    {
        //base case
        if(root == null)
        {
            return;
        };
        temp.add(root.val);
        if(root.left==null && root.right==null && root.val==sum)
        {
            System.out.println(temp);
            output.add(new ArrayList<>(temp));
        }
        else
        {
            sum-=root.val;
            helper(root.left,sum,temp);
            helper(root.right,sum,temp);
        }
        temp.remove(temp.size()-1);
        
        
    }
}