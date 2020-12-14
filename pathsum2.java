class Solution {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currResult = new ArrayList<>();
        dfsHelper(root, sum, currResult, result);
        return result;
    }
    
    private void dfsHelper(TreeNode root, int sum, List<Integer> currResult, List<List<Integer>> result){
        if(root == null)
            return;
        
        currResult.add(new Integer(root.val));
        
        if(root.left == null && root.right ==null && root.val == sum){
            result.add(new ArrayList(currResult));
        }
        else{
            dfsHelper(root.right, sum - root.val, currResult, result);
            dfsHelper(root.left, sum - root.val, currResult, result);   
        }
        currResult.remove(currResult.size() - 1);
    }
}

Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree