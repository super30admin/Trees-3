// we, instead can pass new arraylist in each recursive cycle copying the contents of current cycle to new list
// but draw back is in memory and also time complexity because one-> we are creating new arraylist every recursive call
// and two -> we are copying the contents of one list to another which is also a huge overhead

//s

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
                result.add(path);
            }
        }
        helper(root.left, curSum, targetSum, new ArrayList<>(path));
        helper(root.right, curSum, targetSum, new ArrayList<>(path));
    }
}