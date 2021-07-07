/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
Recursive Solution
LeetCode Submitted : YES
Space Complexity : O(1) //Not counting recursive stack and output list
Time Complexity : O(N^2)

The idea is to recursively call left and sub tree till we reach leaf node and then take sum of the nodes to match the input sum.

**/
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        int currSum = 0;
        paths(root,currSum,sum,new ArrayList<>());
        return output;
    }
    
    private void paths(TreeNode root,int currSum,int sum, List<Integer> temp){
        //Base Condition to exit the recurisve call
        if(root == null)
            return;
        
        currSum += root.val;
        temp.add(root.val);
        
        //Output condition
        if(root.left == null && root.right == null && currSum == sum){
            output.add(temp);
            currSum = 0;
        }
        //calling left sub tree
        paths(root.left,currSum,sum,new ArrayList<>(temp));
        //calling right sub tree
        paths(root.right,currSum,sum,new ArrayList<>(temp));
        
    }
    
}
