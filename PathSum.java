class PathSum {
    // Time Complexity:    O(n^2) 
        // - traverse every element
        // - For every leaf node, we copy the depth number of elements(from root to leaf path) Path into temp
        // ==> n leaf nodes * depth of the leaf node
        // ==> diameter * max depth, where diameter is num of leafnodes, max depth - symtotically max num of nodes for copying
        // ==> worse case - complete binary tree ==> O(n^2)

    // Space Complexity:   O(n)  - currPath, for storing the path or nodes
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
                List<Integer> temp = new ArrayList<>(currPath); // O(n) to copy into new Array
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