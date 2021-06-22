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
// Time Complexity: O(n^2)..in the worst case 
 // O(n^2) if each root-leaf node sum is target.Say we have a completele binary tree then no. of leaf nodes will be n/2. In that case for each leaf node, if sum==target, we copy arrayList and then add it to result. Each such operation takes O(n) ..and we do n/2 such operations in this case. Hence total time complexity will be O(n^2)
// Space Complexity: O(1)...if we consider recursive stack the space complexity will be O(height of tree)
class Solution {
    int target=0;
    List<List<Integer>> res=new ArrayList<>();
   List<Integer> path=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        target=targetSum;
        int currSum=0;
        List<Integer> path=new ArrayList<>();
        findPath(root,currSum);
        
        return res;
        
    }
    
    public void findPath(TreeNode node, int currSum)
    {
        if(node==null)
        {
            
            return;
        }
        currSum+=node.val;
        path.add(node.val);
        if(node.left==null && node.right==null)
        {
            if(currSum==target)
            {
                res.add(new ArrayList(path));
            }
            path.remove(path.size()-1);
            return;
        }
        
        findPath(node.left,currSum);
        
        findPath(node.right,currSum);
        //back tracking
        path.remove(path.size()-1); // This takes O(1) time since we are removing the last element.
        
            
    }
}