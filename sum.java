// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :	Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        paths(root,new ArrayList(),sum);
        return output;
    }
    
    private void paths(TreeNode root,ArrayList list, int sum){

        if(root == null)	// base case
            return;

        list.add(root.val);		// add the root element to the list before checking for children element
        
        sum -=root.val;			// everytime we see a node, sum the node value with sum and recursively traverse until the leaf node is 0
        
        if(root.right == null && root.left ==null && sum ==0)	// if we reach the leaf node and sum is 0, add the list of all the root values to the list
            output.add(new ArrayList(list));

        paths(root.left,list,sum);		// traverse through the tree recursively
        paths(root.right,list,sum);
        list.remove(list.size()-1);
    }
}