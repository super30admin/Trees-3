import java.util.ArrayList;
import java.util.List;

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

// Time complexity = O(n). iterate through the entire tree.
// Space complexity = O(1), if we don't consider the stack height.
// The new arraylist creation is constant. O(1).

// Approach-
// The arraylist is a pointer (reference) inside the stack.
// data structure in a data structure is a reference.
// So after the children recursion gets completed, we remove the element from the path.
// However, the sum which was used for left subtree will always be applied to right subtree.
// I mean there is no difference in terms of passing by value
// The value by reference is the one that needs to be taken care of.

// eg-
//root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22

// stack from bottom ro top
// 5,0,22[] <- [] becomes [5,4,111,7,2] because it is by reference.

class PathSumII {
    List<List<Integer>> lst = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,0, targetSum, new ArrayList<>());
        return lst;
        
    }
    
    private void helper(TreeNode root, int curr, int target,List<Integer> path) {
        if(root==null) {
            return;
        }
        curr = curr + root.val;
        path.add(root.val);
        if(root.left== null && root.right == null) {
            if(curr == target) {
                lst.add(new ArrayList<>(path));
            }            
        }
        helper(root.left, curr, target, path);
        
        helper(root.right, curr, target, path);// the parent value still continues here.
        path.remove(path.size()-1);
        return;
        
    }
}