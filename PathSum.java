class PathSum {
    
    List<List<Integer>> output = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // output = new ArrayList<>();
        if(root == null)
            return new ArrayList();
        
        helper(root, sum, 0, new ArrayList());
        return output;
    }
    
    public void helper(TreeNode root, int target, int prevSum, List<Integer> currPath){
        if(root == null)
            return;
        
        int currSum = prevSum + root.val;
            
        if(root.left == null && root.right == null){
            if(currSum == target){
                //New List is required since when currPath changes, the list in output will also change
                // since reference is passed (as value in Java)
                List<Integer> temp = new ArrayList<>(currPath);
                temp.add(root.val);
                output.add(temp);
            }
            return;
        }
        currPath.add(root.val); // Adding to Path
        
        helper(root.left, target, currSum, currPath);
        helper(root.right, target, currSum, currPath);
        
        // Once left and right are done, remove the node
        currPath.remove(currPath.size() - 1); 
    }
    
}