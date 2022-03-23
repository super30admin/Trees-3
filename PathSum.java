//Time Complexity: O(N)
//Space COmplexity: O(H) Height of the tree

class Solution {
    List<List<Integer>> result;
    int targ;  
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       targ = targetSum;
       result = new ArrayList<>();
       helper(root, 0, new ArrayList<>());
       return result; 
    }
    private void helper(TreeNode root, int currSum, List<Integer> path){
        //base
        if(root == null) return;
        //logic
        currSum += root.val;
        //action
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(currSum == targ){
                
                result.add(new ArrayList<>(path));
            }
        }
        
        
        //recurse
        helper(root.left, currSum, path);
        helper(root.right, currSum, path);
        
        //backtrack
        path.remove(path.size() - 1);
    }
}