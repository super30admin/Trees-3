// Time Complexity : O(n^2) as path created for each node and for creation we have to traverse and copy existing path
// Space Complexity : O(n^2 + h)  as paths created at each node O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


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
class Solution {
    int target; // global variable target sum
    List<List<Integer>> result = new ArrayList<>(); //global result so that we dont have to pass again and again
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        target = sum;
        helper(root, 0, path); // calling helper for sum 0 and path pointer to empty list
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path)
    {
        //base
        if(root==null) // when we reach the null node
            return;

        //logic
        sum += root.val; // finding sum for the node for which the call is made using prev sum
        
        path.add(root.val); // adding node to path
        
        //if leaf node we have to if check target is found
        if(root.left==null && root.right == null)
        {
            if(sum==target)
                result.add(path); // if target found we add path to result
        }
       
        helper(root.left, sum, new ArrayList<>(path)); // calling on left subtree by creating a copy of the path and passing its pointer as the original path is getting changed
        helper(root.right, sum, new ArrayList<>(path)); // calling on right subtree
        
        
    }
}

// Time Complexity : O(n^2)
// Space Complexity : O(h+n) as only one list maintained
// Did this code successfully run on Leetcode :  Yes 
// Any problem you faced while coding this : None


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
class Solution {
    int target; // global variable target sum
    List<List<Integer>> result = new ArrayList<>(); //global result so that we dont have to pass again and again
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        target = sum;
        backtrack(root, 0, path); // calling helper for sum 0 and path pointer to empty list
        return result;
    }
    
    private void backtrack(TreeNode root, int sum, List<Integer> path)
    {
        //base
        if(root==null)
            return;
        
        
        //logic
        //Action
        sum += root.val; // finding sum for the node for which the call is made using prev sum
        path.add(root.val); // adding node to path
        
         //if leaf node we have to if check target is found
        if(root.left==null && root.right == null)
        {
            if(sum==target)
                result.add(new ArrayList<>(path)); // if target found we make a new copy of path and add it to result as we will be removing elements from original path
        }
       
        //Recurse
        backtrack(root.left, sum,  path); // call on left
        backtrack(root.right, sum, path); // call on left
        
        //Backtrack
        path.remove(path.size()-1); // when recursion ends and element is popped out of stack, backtrack and remove the node from teh path as well
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h+h) = O(h)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //edge case
        if(root == null)
            return true;
        
      return helper(root.left, root.right); // calling on  left of root and right of root
    }
    
    private boolean helper(TreeNode left, TreeNode right)
    {
        //base
        if(left == null && right == null) // when both left and right tree has reached null
          return true;
        
        //logic
        if(left==null || right == null || left.val != right.val) // if the value of left and right tree are not equal or we have reached end of one of the tree
            return false; // then tree is not symmetric
        
       boolean branch1 = helper(left.left, right.right); // calling to check the left's left and right's right
       boolean branch2 = helper(left.right, right.left); // calling to check the left's right and right's left
        
        return branch1 && branch2; // taking AND of the result of the two
    }
}