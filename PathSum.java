/**
* TC - O(N^2), SC O (N^2)
* Approach 1- Pure recursive approach 
 */
class Solution {
    List<List<Integer>> ans= null ; 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       ans = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return ans;

    }
    public void helper(TreeNode root, int currSum,  int targetSum, List<Integer> path){
        // base
        if (root == null) return ; 
        
        //logic
        currSum += root.val;
        path.add(root.val);
        
        helper(root.left, currSum,targetSum,  new ArrayList<>(path));
        if (root.left ==null && root.right == null && currSum == targetSum){
            ans.add(new ArrayList<>(path));
        }
        helper(root.right, currSum, targetSum, new ArrayList<>(path));

        
    }
}

/*o(N), O(N) Backtracking since we are not creating new array at every node 
 * Using the same reference 
 * */
class Solution {
    List<List<Integer>> ans= null ; 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       ans = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return ans;

    }
    public void helper(TreeNode root, int currSum,  int targetSum, List<Integer> path){
        // base
        if (root == null) return ; 
        
        //logic
        currSum += root.val;
        path.add(root.val);
        
        helper(root.left, currSum,targetSum,  path);
        if (root.left ==null && root.right == null && currSum == targetSum){
            ans.add(new ArrayList<>(path));
        }
        helper(root.right, currSum, targetSum, path);
        path.remove(path.size()-1);
        
    }
}


