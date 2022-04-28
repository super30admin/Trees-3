//time - O(n)
//space - O(h)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path){
        if(root==null) return;

        currSum+=root.val;

        path.add(root.val);

        if(root.left==null && root.right==null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, currSum, targetSum, path);
        helper(root.right, currSum, targetSum, path);
        path.remove(path.size()-1);
    }
}