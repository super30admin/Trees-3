// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h+h) for recurisive stack and path list, where h is the height of the tree.
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
    List<IList<int>> ans;
    int pathSum, targetSum;
    List<int> path;
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        ans = new List<IList<int>>();
        path = new List<int>();
        this.targetSum = targetSum;
        pathSum = 0;
        PathSum(root);
        return ans;
    }
    
    public void PathSum(TreeNode node){
        if(node == null) return;
        
        // add current node to path
        path.Add(node.val);
        pathSum += node.val;
        
        // if leaf node and pathsum is target add the path to result
        if(node.left == null && node.right == null){
            if(pathSum == targetSum){
                ans.Add(new List<int>(path));
            }
        }
        
        // continue tarversal
        PathSum(node.left);
        PathSum(node.right);
        
        // backtrack and remove current node from path
        path.RemoveAt(path.Count-1);
        pathSum -= node.val;
    }
}