// Time- O(N)
// Space - O(N^2)
class Solution {
    List<List<Integer>> result = new ArrayList<>(); 
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) {
            return new ArrayList<>();
        }
        helper(root, sum, 0, new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(TreeNode root, int sum, int curSum, List<Integer> path) {
        if(root == null) {
            return;
        }
        int newSum = root.val + curSum;
        path.add(root.val);        
        
        if(root.left == null && root.right == null) {
            if(sum == newSum) {
                result.add(path);        
            }
        }
        

        helper(root.left, sum, newSum, new ArrayList<>(path));
        helper(root.right, sum, newSum, new ArrayList<>(path));    
        
    }
    
}

// Time - O(N)
// Space - Amortized O(N)
// backtracking
class Solution {
    List<List<Integer>> result = new ArrayList<>(); 
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) {
            return new ArrayList<>();
        }
        helper(root, sum, 0, new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(TreeNode root, int sum, int curSum, List<Integer> path) {
        if(root == null) {
            return;
        }
        int newSum = root.val + curSum;
        path.add(root.val);        
        
        if(root.left == null && root.right == null) {
            if(sum == newSum) {
                result.add(new ArrayList<>(path));
            }
        }
        

        helper(root.left, sum, newSum, path);
        helper(root.right, sum, newSum, path);    
        
        path.remove(path.size()-1);
    }
    
}
