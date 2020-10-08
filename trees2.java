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


//Time complextiy = O(N square)
//Space Complexity =O(N)


class Solution {
// Declare List of list
    public List<List<Integer>> pathSum(TreeNode root, int sum) { 
        
        List<List<Integer>> p = new ArrayList<>();
        find(root, sum, new ArrayList<>(), p);
        return p;
        
    }
    
    void find(TreeNode root, int sum, List<Integer> c, List<List<Integer>> p)
        
    {
        if (root==null)
            return;
        c.add(root.val);
        if(root.val==sum && root.left==null && root.right==null)
        {
            p.add(c);
            return;
        }
        else
        {
        
        // Look for node that has the remainig sum
            find(root.left,sum-root.val,new ArrayList<Integer>(c),p);
            find(root.right,sum-root.val,new ArrayList<Integer>(c),p);
        }
        
        
        
    }
    
    
}
