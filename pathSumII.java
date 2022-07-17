// Time Complexity :O(N) in traversing the tree because list's maximum size would be H
// Space Complexity :O(H) because maximum element in the list would be H and same as in recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    int target;
    List<List<Integer>> result; 
    List<Integer> temp; // temporary list
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>(); // initializing
        temp = new ArrayList<>();
        
        if(root == null) return result;
        target = targetSum; // global 
        helper(root,0);// sum=0 in starting
        return result;
    }
    
    private void helper(TreeNode root, int sum){
        if(root == null) return;
        // adding the sum 
        sum += root.val;
        // adding it to the temp list
        temp.add(root.val);
        //checking for conditions for leaf nodes
        if(sum == target && root.left == null && root.right == null){
            result.add(List.copyOf(temp));
        }

        helper(root.left,sum);
        helper(root.right,sum);
        temp.remove(temp.size()-1);
    }