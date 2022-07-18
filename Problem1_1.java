//Time Complexity : O(n*h), where h is the height of the tree; to copy a new ArrayList each time
//Space Complexity: O(h), problem requires a list of list output, only recursion stack space is additional.
//Code run succesfully on LeetCode.

public class Problem1_1 {
	
	List<List<Integer>> result;
    int target = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<>();
        target = targetSum;
        
        if(root == null) return result;
        
        helper(root, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path){
        
        if(root == null)
            return;
        
        sum = sum + root.val;
        path.add(root.val);
        
        if(target == sum){
            if(root.left == null && root.right == null){
                result.add(path); 
                return;
            }
                 
        }
       
        helper(root.left, sum, new ArrayList<>(path));
        helper(root.right, sum, new ArrayList<>(path));
    }

}
