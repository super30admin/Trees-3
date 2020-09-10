// Time Complexity : o(n) where n is the number of nodes of the tree
// Space Complexity : o(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
class PathSum2 {
    //initialze result as global variable 
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //call the helper function with root, sum and an empty linkedlist
        helper(root,sum,new LinkedList<>());
        return answer;
    }

    public void helper(TreeNode root, int sum, LinkedList<Integer> result) {
        //base function
        if(root == null) return;
        sum = sum - root.val;
        //logic: if it is the leaf node
        if(root.left==null && root.right == null){
            //check if the sum = 0, as sum is getting subtracted from each node value
            if(sum == 0){
                //add the leaf node value to the result
                result.add(root.val);
                //add the result list to the answer list
                answer.add(new ArrayList<>(result));
                //remove the last element from the result list as we need to check for the other path from the previous node
                result.removeLast();
            }
            
        }
        //add node value to the result
        result.add(root.val);

        //recursive call to the left and right of the nodes
        helper(root.left, sum, result);
        helper(root.right, sum, result);

        //remove the last element to add the node from the other path
        result.removeLast();
    } 
        
        
    }
        
