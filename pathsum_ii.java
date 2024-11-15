// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//approach: we used back tracking here. maintained path for everynode. for every left node added, we added the node to the path,
//adn when we are going to the right node, we removed it from the path. for every leaf node, we checked if the target is equal to 
// current sum, if so we added it to the result list.

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
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res=new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>());
        return res;
        
    }

    public void helper(TreeNode root,int target,int cur,List<Integer> path)
    {
        if(root==null)
            return;
        cur=cur+root.val;
        path.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(cur==target)
                res.add(new ArrayList<>(path));
        }
        helper(root.left,target,cur,path);
        helper(root.right,target,cur,path);
        path.remove(path.size()-1);
    }
}