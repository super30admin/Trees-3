// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach we keep a list of lists in which we keep adding lists of integers i.e the nodes to this second list that sum up from root
// to leaf equal to the target.We use recurion here to move from root to leaf and keep adding the nodes value that come in the path.
// Whenever the sum equals the target we add that to the main list.
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      
      
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> current = new ArrayList<>();
     
      pathSum(root,targetSum,0,result,current);
      return result;
    }
      
      
      private void pathSum(TreeNode root,int target,int currentSum,List<List<Integer>> result,List<Integer> current)
      {
        if(root == null)
        {
          return;
        }
        
        currentSum = currentSum + root.val;
        current.add(root.val);
        
        if(root.left == null && root.right==null)
        {
          if(currentSum == target)
          {
            List<Integer> temp = new ArrayList<>(current);
            result.add(temp);
          }
          current.remove(current.size()-1);
          return;
        }
          
        pathSum(root.left,target,currentSum,result,current);
        pathSum(root.right,target,currentSum,result,current);
        
        current.remove(current.size()-1);
      }
        
    
}