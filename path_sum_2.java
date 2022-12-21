//TC: O(n)
//SC: O(n)

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        dfs(root, targetSum);
        return res;
    }
    
    void dfs(TreeNode root, int targetSum){
        if(root == null) return;
        targetSum -= root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(list));
        } 
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum); 
        targetSum += root.val;
        list.remove(list.size()-1);
    }
}