// Time Complexity : O(n2)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class PathSum {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        //base condition
        if(root == null) return;

        currSum += root.val;
        path.add(root.val);
        //logic
        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                result.add(new ArrayList<>(path));
                return;
            }
        }
        //recurssion
        helper(root.left, targetSum, currSum, new ArrayList<>(path));
        //st.pop()
        helper(root.right, targetSum, currSum, new ArrayList<>(path));
        //st.pop()

    }
}

//Backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        //base condition
        if(root == null) return;

        currSum += root.val;
        path.add(root.val);
        //logic
        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        //recurssion
        helper(root.left, targetSum, currSum, path);
        //st.pop()
        helper(root.right, targetSum, currSum, path);
        //st.pop()
        path.remove(path.size() - 1);

    }
}