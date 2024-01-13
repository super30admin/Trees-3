// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return Collections.emptyList();
        }

        // leaf node
        if(root.left == null && root.right == null){
            LinkedList<Integer> list = new LinkedList<>();
            if(targetSum == root.val) {
                list.add(root.val);
                result.add(list);
            }
            return result;
        }

        //System.out.println(root.val);

        // not leaf
        if(root.left != null){
            List<List<Integer>> leftPaths = pathSum(root.left, targetSum - root.val);
            for(List<Integer> path : leftPaths) path.addFirst(root.val);
            result.addAll(leftPaths);
            //System.out.println("Left paths with sum " + (targetSum - root.val) + " " + leftPaths.size());
        }

        if(root.right != null){
            List<List<Integer>> rightPaths = pathSum(root.right, targetSum - root.val);
            for(List<Integer> path : rightPaths) path.addFirst(root.val);
            result.addAll(rightPaths);
            //System.out.println("Right paths with sum " + (targetSum - root.val) + " " + rightPaths.size());
        }

        return result;

    }
}
