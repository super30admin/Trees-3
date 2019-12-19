/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Algorithm:

    1. We will cover all the possible paths to the leaf nodes
    2. When at leaf node we check if the sum condition is satisfying, if yes we will add this path to the result list.
    3. We return the result.
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Did the code run on leetcode? Yes

*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        dfs(root, sum, result, path);
        
        return result;
        
    }
    
    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path){
        //Case 1
        if(root==null)
            return;
        path.add(root.val);
        
        //Case 2
        if(root.left==null && root.right==null){
            if(sum==root.val){
                result.add(new ArrayList<>(path));
                return;
            }
        }
        
        //Case 3
        if(root.left!=null){
            dfs(root.left, sum-root.val, result, path);
            
            path.remove(path.size() -1);
        }
        
        if(root.right!=null){
            dfs(root.right, sum-root.val, result, path);
            
             path.remove(path.size() -1);
            
        }
            
    }
    
    
}