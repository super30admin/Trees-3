//Time complexity : O(n)
//Space Complexity : O(n)

class PathSumII {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        dfs(root, 0,new  ArrayList<Integer>(), targetSum);
        return result;
    }
    public void dfs(TreeNode root,int currSum,List<Integer> path, int targetSum){
        //base
        if(root == null){
            return;
        }
        //logic
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
                // return;
            }
        }
        dfs(root.left,currSum, path, targetSum);
        dfs(root.right,currSum, path, targetSum);
        path.remove(path.size()-1);
    }
}
