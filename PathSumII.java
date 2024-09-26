/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(N) since each of the nodes will be visited once
// Space Complexity : O(log(N)), that is if we don't consider result. 


// Your code here along with comments explaining your approach
//recursion, this solution uses an ArrayList instead of a stack

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

    	List<List<Integer>> paths = new ArrayList<>();
    	findPaths(root, sum, new ArrayList<Integer>(), paths);

    	return paths;
    }

    public void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths) {
    	if(root == null) {
    		return;
    	}

    	current.add(root.val);
    	if(root.val == sum && root.left == null && root.right == null) {
    		paths.add(current);
    		return;
    	}

    	findPaths(root.left, sum - root.val, new ArrayList<Integer>(current), paths);
    	findPaths(root.right, sum - root.val, new ArrayList<Integer>(current), paths);
    }
}