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
/**
Algorithm :

if(leafnode & target == sum)
return o/p

update path, update sum

helper(node.left, ...... )
helper(node.right, ...... )
remove(path)

//current path changes only when we have processed right and left sub tree.
helper(root, target, curPath, o/p, curSum){

}

SC : O(H) recursion + O(c*H) for maintaing temp
where c is const number of times when we have a valid ans
TC : O(n)
**/

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return new ArrayList<>();
        
        List<Integer> curPath = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        
        helper(root, sum, 0, curPath, output);
        
        return output;
        
    }
    
    private void helper(TreeNode root, int target, int curSum, List<Integer> curPath, List<List<Integer>> output){
        if(root == null)
            return;
        
        //Logic
        if(root.left == null && root.right == null){
            if(curSum + root.val == target) {
                List<Integer> temp = new ArrayList(curPath);
                temp.add(root.val);
                
                output.add(temp);
            }
        }
        
        curPath.add(root.val);
        
        
        // if (root.left != null)
        helper(root.left, target, curSum + root.val, curPath, output);
        helper(root.right, target, curSum + root.val, curPath, output);
        
        curPath.remove(curPath.size() - 1);
    }
    
}