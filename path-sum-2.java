//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helperMethod(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    
    private void helperMethod(TreeNode root, int currentSum, List<Integer> path, int targetSum) {
        //base
        if(root == null) {
            return;
        }
        
        //logic
        currentSum = currentSum + root.val;
        path.add(root.val);
        helperMethod(root.left, currentSum, path, targetSum);
        if(currentSum == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        helperMethod(root.right, currentSum, path, targetSum);
        path.remove(path.size() - 1);
    }
}