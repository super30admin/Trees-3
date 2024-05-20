// UnOptimized
// Time Complexity : O(totalNodes * height)
// Space Complexity : O((height * totalNodes) + Height) new list will need space (height * totalNodes)
//                      and additionally we need stack that will take (height)


// Optimized
// Time Complexity : O(totalNodes * height)
// Space Complexity : O(height) we need stack that will take (height) space


// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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

public class PathSumII {
    // Time Complexity = O(totalNodes * height)
    // SPace Complexity = O(height * totalNodes + Height) new list will need space (height * totalNodes)
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int currentSum = 0;
        helper(root, targetSum, currentSum, new ArrayList<Integer>());
        return result;
    }

    // UnOptimized Solution
    public void helper(TreeNode root, int targetSum, int currentSum, List<Integer> list){
        if(root == null) return;

        currentSum += root.val;
        list.add(root.val);

        if(root.left == null && root.right == null){
            // we are at leaf node, here we will be comparing current sum with
            if(targetSum == currentSum){
                result.add(list);
            }
            // else nothing, carry on with other nodes
        }

        // explore left side
        helper(root.left, targetSum, currentSum, new ArrayList<>(list));// creating new array with old data because in dataStructure inside dataStructure is reference, so we have to deep copy the elements by creating new arrayList.

        // also explore right side
        helper(root.right, targetSum, currentSum, new ArrayList<>(list));
    }

    // Optimized Solution
    public void optimizedHelper(TreeNode root, int targetSum, int currentSum, List<Integer> list){
        if(root == null) return;

        currentSum += root.val;
        list.add(root.val);

        if(root.left == null && root.right == null){
            // we are at leaf node, here we will be comparing current sum with
            if(targetSum == currentSum){
                // creating a new list that will be added to result
                result.add(new ArrayList<>(list));
            }
            // else nothing, carry on with other nodes
        }

        // explore left side
        optimizedHelper(root.left, targetSum, currentSum, list);

        // also explore right side
        optimizedHelper(root.right, targetSum, currentSum, list);

        // backtracking
        list.remove(list.size() -1);
    }
}
