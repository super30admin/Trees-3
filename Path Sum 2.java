class Solution {
    List<List<Integer>> result;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        result = new ArrayList<>();
        target = targetSum;
        dfs(root, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }
        //logic
        //action
        path.add(root.val);
        int currSum = sum + root.val;
    System.out.println(path);
        if (root.right == null && root.left == null) {
            if (currSum == target) {
                result.add(new ArrayList<>(path));
                
             
            }
           
        }
        //recurse
        dfs(root.left, currSum, path);
        dfs(root.right, currSum, path);
        
        //backtrack
        path.remove(path.size() - 1);
    
    }
}
