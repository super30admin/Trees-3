
 //Time complexity - O(nh) - at each node, extra time is taken to copy the nodes along the height. 
 //Space Complexity - n lists crreated with h elements each in a list. O(nh)
 class Solution {
    List<List<Integer>> result;
    int sum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList();
        }
        result = new ArrayList<>();
        dfs(root,0, new ArrayList<>(),targetSum);
        return result;


        
    }
    private void dfs(TreeNode root, int currSum, List<Integer> path, int target){
        if(root == null){
            return;
        }
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(path);
            }
            return;
        }
        dfs(root.left,currSum,new ArrayList<>(path),target);
        dfs(root.right,currSum,new ArrayList<>(path),target);
    }
}