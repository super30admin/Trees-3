// Time Complexity :O(n)// n is no. of nodes in the tree
// Space Complexity :o(h) //h is the height of the Tree //recursive stack space
// Did this code successfully run on Leetcode 113:yes
// Any problem you faced while coding this :


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
     List<List<Integer>> l;
    List<Integer> li;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return  new ArrayList<List<Integer>>();
        l=new ArrayList<>();
        li=new ArrayList<>();
         helper(root,targetSum,0,li);
        return l;
    }
    private void helper(TreeNode root,int targetsum,int currsum, List<Integer> li){
        if(root==null)
            return;
         li.add(root.val);
        currsum=currsum+root.val;
        if(root.left==null&&root.right==null){
            if(currsum==targetsum)
            {
                l.add(new ArrayList<Integer>(li));
            }
        }
        helper(root.left,targetsum,currsum,li);
        helper(root.right,targetsum,currsum,li);
        li.remove(li.size()-1);
    }
}