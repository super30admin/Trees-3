// Time Complexity : The time complexity is O(n) where n is the number of nodes
// Space Complexity : The space complexity is O(h) where h is the height of the tree
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
class Solution {

    List<List<Integer>> output = new LinkedList<>();;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if(root == null){
            return output;
        }

        treePath(root,sum,new LinkedList<>());

        return output;

    }

    public void treePath(TreeNode root, int sum,List<Integer> list){

        list.add(root.val);
        sum -= root.val;

        // If the node is leaf and sum is zero, we found the path
        if(sum == 0 && root.left==null && root.right==null){
            output.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        if(root.left != null){
            treePath(root.left,sum,list);
        }

        if(root.right != null){
            treePath(root.right,sum,list);
        }

        list.remove(list.size()-1);

    }
}