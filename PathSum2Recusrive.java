// Time Complexity : O(nh) => We are visiting n nodes as well as copying all the element with each recursive call which can be h in worst case
// Space Complexity : O(nh) => As we create new list with each left and right recursive call
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: In this approach we have global variable sum and local variable current sum which holds the sum of that particular recursive call. For each leaf node we compare with the targetSum and add the result to the final resultant list
 */
class Solution {
    int sum;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return new ArrayList<>();
        }

        sum = 0;
        result = new ArrayList<>();
        dfs(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int targetSum, int currentSum, List<Integer> path) {

        if (root == null) {
            return;
        }

        currentSum = currentSum + root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){

            if(currentSum == targetSum){
                result.add(path);
                return;
            }
        }

        //Creating new list and copying the current elememts in path
        dfs(root.left, targetSum, currentSum, new ArrayList<>(path));
        dfs(root.right, targetSum, currentSum, new ArrayList<>(path));

    }
}