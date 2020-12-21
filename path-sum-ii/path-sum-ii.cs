/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<IList<int>> PathSum(TreeNode root, int sum) {
        List<IList<int>> pathlist = new List<IList<int>>();
        List<int> pathnodes = new List<int>();
        recurseTree(root,sum,pathnodes,pathlist);
        return pathlist;
        
    }
    
    public void recurseTree(TreeNode node,int sum, List<int> pathnodes,List<IList<int>> pathlist)
    {
        if(node==null) return;
        pathnodes.Add(node.val);
        
        if(sum==node.val && node.left ==null && node.right ==null)
        {
            pathlist.Add(new List<int>(pathnodes));
        }
        else
        {
         recurseTree(node.left,sum-node.val,pathnodes,pathlist);
            recurseTree(node.right,sum-node.val,pathnodes,pathlist);
        }
        
        pathnodes.RemoveAt(pathnodes.Count-1);
    }
}
