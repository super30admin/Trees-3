// backtracking -> in backtracking we have: action , recurse, backtrack
// in this case:: action -> adding of node to the path
// recurse -> we go left and right of the root
// backtrack -> we undoing of action ie removal of node

//this is an efficient method because im not creating a separate list at every point
//time is also saved cuz we arent copying over elements at every node
//backtracking hence is a optimization to recursion


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int curSum, int targetSum, List<Integer> path) {
        if(root == null) {
            return;
        }
        curSum = curSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(curSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, curSum, targetSum, path);
        helper(root.right, curSum, targetSum, path);
        path.remove(path.size() - 1);
    }
}