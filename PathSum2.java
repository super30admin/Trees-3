//TC : o(n)
//SC : o(n)
//https://leetcode.com/problems/path-sum-ii/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        dfs(root,0, new ArrayList<>(),targetSum);
        return result;
    }
    
    private void dfs(TreeNode root, int sum,List<Integer> li, int targetSum){
        //base
        if(root == null) return;
        //logic
        sum += root.val;
        li.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum){
            
            result.add(new ArrayList<>(li));
        }
        dfs(root.left, sum,li, targetSum);
        dfs(root.right, sum,li, targetSum);
        li.remove(li.size()-1);
    }
}
