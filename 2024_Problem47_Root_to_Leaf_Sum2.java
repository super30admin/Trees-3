//113. Path Sum 2 - https://leetcode.com/problems/path-sum-ii/description/
//Time Complexity: O(n*h) -> at every place we are copying elements
//Space Complexity: O(n*h) + O(h) -> height of the tree

//Recurrsion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.result = new ArrayList<>();
        dfs(root, sum, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int targetSum, int currSum, List<Integer> path){
        //base case
        if(root == null)
            return;
        List<Integer> list = new ArrayList<>(path);
        currSum = currSum + root.val;
        list.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(list);
            }
        }
        dfs(root.left, targetSum, currSum, list);
        dfs(root.right, targetSum, currSum, list);
    }
}

//Backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.result = new ArrayList<>();
        dfs(root, sum, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int targetSum, int currSum, List<Integer> path){
        //base case
        if(root == null)
            return;

        //action
        path.add(root.val);
        currSum = currSum + root.val;


        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        //recurse
        dfs(root.left, targetSum, currSum, path);
        dfs(root.right, targetSum, currSum, path);

        //backtrack
        path.remove(path.size()-1);
    }
}