//TC = O(n*h)
//SC = O(n*h) 
// Here we are creating new list to store element in at enveyr node. ans check for the currsum.

class PathSum2 {
    List<List<Integer>> result;
     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            this.result = new ArrayList<>();
            helper(root, 0, targetSum, new ArrayList<>());
            return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path) {
        //base
        if(root == null) return;
        //logic
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                  result.add(path);
            }
        }
        helper(root.left, currSum, targetSum, new ArrayList<>(path));
        helper(root.right, currSum, targetSum, new ArrayList<>(path));
    }
}