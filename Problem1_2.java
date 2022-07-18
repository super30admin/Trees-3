//Time Complexity: O(n) + O(2^h * h); sum of time to traverse each node and generate the output when target reaches sum in the worst case;
//Space Complexity : O(h); since problem itself requires a list of list output.
//Code run succesfully on LeetCode.

public class Problem1_2 {

	List<List<Integer>> result;
    List<Integer> path;
    int target = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;
        
        if(root == null) return result;
        
        helper(root, 0);
        
        return result;
    }
    
    private void helper(TreeNode root, int sum){
        
        if(root == null)
            return;
        
        sum = sum + root.val;
        path.add(root.val);
        
        if(target == sum){
            if(root.left == null && root.right == null){
                result.add(new ArrayList<>(path));
            }     
        }
       
        helper(root.left, sum);
        helper(root.right, sum);
        path.remove(path.size() - 1);
        
    }
	
}
