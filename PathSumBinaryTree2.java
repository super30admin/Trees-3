import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */

 // Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach
1) use basic recursion pre-order traversal 
2) insert elements into temporary list and if its a leaf node, then check the condition and add the elements into another list. 
3) go to left and right 
4) point to note: we need to allocate new arrayList<>(path) in recursion call as we need to separate out the lists encountered 
thus it would become -> [5],[5,9],[5,9,10] and finally when we satisfy the condition, then we just add it into an empty list.
and lst would have[[5,9,10]] and so on

*/



 
  
 
class Solution {
    
    public class TreeNode {
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




    List<List<Integer>> lst;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root==null)
            return new ArrayList<>();
        
        lst = new ArrayList();
        
        helper(root,targetSum,new ArrayList<Integer>());
        return lst;
    }
    
    public void helper(TreeNode root, int targetSum, List<Integer> path)
    {
        // base case 
        if(root==null)
        {
            return ;
        }
        
        // recursion logic
        path.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(targetSum-root.val==0)
            {
                lst.add(path);
            }
        }
        
        helper(root.left,targetSum-root.val,new ArrayList<>(path));
        helper(root.right,targetSum-root.val,new ArrayList<>(path));
        
        
    }
}