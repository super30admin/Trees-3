class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        output = new ArrayList<List<Integer>>();
        helper(0, new ArrayList<Integer>(), root, sum);
        return output;
    }
    
    private void helper(int curr_sum, List<Integer> curr_path, TreeNode node, int target){
        // Base case
        if(node == null) return;
        
        curr_path.add(node.val);
        curr_sum += node.val;
        
        if(node.left==null && node.right==null && target==curr_sum){
            output.add(new ArrayList<>(curr_path));
        }
        else{
            helper(curr_sum, curr_path, node.left, target);
            helper(curr_sum, curr_path, node.right, target);
        }
        curr_path.remove(curr_path.size()-1);
    }
}

// TC- O(N*2)
// SC-O(N)
/* Important parts here are to create a new arraylist for each of the path.
This way only the current copy of path is sent to output list. 
Otherwise, we may get mixed paths for the paths that differ only on some nodes. 
Also, need to remove the last added element for the path to ensure no mixed elements are present. */
