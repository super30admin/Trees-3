//approach - BF - make a deep copy at every node!!
//TC: O(n*h)
//sc: O(n*h)



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


public class Solution {
    List<IList<int>> result;
    //List<int> path;
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        
        result = new List<IList<int>>();
        //path = new List<int>();
        
        helper(root, targetSum, 0, new List<int>());
        return result;
    }
    
    private void helper(TreeNode root, int target, int rsum, List<int> path)
    {
        //base case
        if(root  == null) return ;
        
        rsum = rsum+root.val;
        List<int> li = new List<int>(path);
        li.Add(root.val);
        
        //logic
        //leaf node
        if(root.left == null && root.right == null && target == rsum)
        {
            result.Add(li);
            return;
        }
        
        helper(root.left, target, rsum,li);
        helper(root.right, target, rsum,li);
        
    }
}





//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Backtrackign approach
//TC: O(N)
//SC: O(h)

public class Solution {
    List<IList<int>> result;
    List<int> path;
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        
        result = new List<IList<int>>();
        path = new List<int>();
        
        helper(root, targetSum, 0);
        
        return result;
    }
    
    private void helper(TreeNode root, int target, int currsum)
    {
        //base case
        if(root  == null) return;
        
        //Action
        currsum = currsum + root.val;
        path.Add(root.val);
        
        if(root.left == null && root.right == null && target == currsum)
        {
            result.Add(new List<int>(path));
            //return; - don't write this while backtracking else it wont give correct result if return at middle!
        }
        
        //recusrion
        helper(root.left, target, currsum);
        helper(root.right, target, currsum);
        
        //backtrack
        path.RemoveAt(path.Count -1);
        
    }
    
}