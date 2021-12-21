// Time Complexity = O(n)
// Space Complexity = O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<>();
        helper(root, targetSum, 0, path);
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, ArrayList<Integer> path) {
        //base case
        if (root == null) {
            return;
        }

        // Logic
        currSum += root.val;    // currSum will keep a track of the root values till now
        path.add(root.val);     // path will have a list of all the nodes visited till now

        if (root.left == null && root.right == null) {  // if leaf node
            if (targetSum == currSum) {                 // if the currSum equals to the targetSum, we got our path
                result.add(new ArrayList<>(path));      // We will add the path list to the result list
            }
        }
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);
        path.remove(path.size()-1);     // We will remove the last element each time its no longer needed
    }
}