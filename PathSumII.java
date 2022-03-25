// Time Complexity : O(n^2) - Recursive ; O(n) - Backtracking
// O(n) (iterating all nodes) * O(h) (copying elements of earlier list into new list) = O(nh) worst case = O(n^2) - when tree is left skewed
// Space Complexity : O(n) - Recursive ; O(n) - Backtracking
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Intuition is to calculate sum on a single path and not the whole tree, thus we keep local variables - path and sum, saved locally at each node.
Now to avoid creating multiple lists, we create one when the leaf node is reached and save it.
With the use of backtracking, after left child and right child of any node are done, then we remove it from the list because if it would have constituted the path, it would have been already added in the list and not reach here.

We can do pre, in or postorder traversal with increasing sum and added path and only add to result if we know that target = sum and it is a leaf node.
 */

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), target);
        return result;
    }

    //recursive
    public void helper(TreeNode root, int sum, List<Integer> path, int target){
        //base
        if(root == null) return;

        //logic
        sum += root.val;
        //action
        path.add(root.val);
        if(root.left == null && root.right == null ){
            if(target == sum){
                result.add(new ArrayList<>(path)); //new list is created when at leaf, because we want to save the path only for elements that constituted the path and not the ones who did not play part and terminated after their left and child traversal. the list is same thus while iterating right these values will be backtracked.
                //result.add(path); //no need to take a new list here as it is already new, when calling the recursion function
                //return; //on adding return it gives a diff value.
            }
        }
        helper(root.left, sum, path, target);
        //helper(root.left, sum, new ArrayList<>(path), target); //making new list every time as primitive data types are stored in other primitive datatypes by reference

        helper(root.right, sum, path, target);
        //helper(root.right, sum, new ArrayList<>(path), target);
        //backtrack
        path.remove(path.size()-1);
    }

}
