class Solution {
    List<List<Integer>>result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root==null){
            return new ArrayList<>();
        }

        dfs(root,0,targetSum,new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int currSum, int targetSum,List<Integer>path)
    {
        if(root==null){
            return;
    }
    path.add(root.val);
    currSum = currSum + root.val;
    dfs(root.left,currSum,targetSum,path);

    if(root.left==null && root.right==null &&currSum == targetSum){
        result.add(new ArrayList<>(path));
    }
    dfs(root.right,currSum,targetSum,path);
    path.remove(path.size()-1);
}}
