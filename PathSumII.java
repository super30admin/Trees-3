class PathSumII {
    // Approach 1 - Iterative approach 
    // Time complexity  O(n)
    // Space Complexity O(logn)
    //Tested in leetcode
    public List<List<Integer>> pathSum(TreeNode root, int sum ) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        int total = 0;
        
        while(curr != null || !stack.isEmpty()){
            
            //push leftmost node into stack
            while(curr != null){
                stack.push(curr);
                total += curr.val;
                temp.add(curr.val);
                curr = curr.left;
            }
            
            //iterate to rightmost node of the leftmost node
            curr = stack.peek();
            if(curr.right != null && curr.right != prev){
                    curr = curr.right;
                continue;
            }
            
            //If leaf node and total sum of node value is sum then store the array 
            if(curr.left == null && curr.right == null){
                if(sum == total)
                    result.add(new ArrayList<>(temp));
            }
            
            prev = curr;
            stack.pop();
            //remove last entry from the temp array
            temp.remove(temp.size()-1);
            total -= curr.val;
            curr = null;
        }
        return result;
    }
    
    
    //Approach 2  - Recursion
    // Time complexity  O(n)
    // Space Complexity O(logn)
    // Tested in leetcode 
    
    //global variable for storing array
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum ) {
        if(root == null)
            return new ArrayList<>();
        helper(root,sum, new ArrayList<Integer>());
        return result;
    }
    
    // helper function for Approach 2
    public void helper(TreeNode root, int sum, ArrayList<Integer> temp){
        if(root == null)
            return;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == root.val)
                result.add(new ArrayList<>(temp));
            return;
        }
        
        if(root.left != null){
            helper(root.left,sum-root.val,temp);
            temp.remove(temp.size()-1);
        }
         
        if(root.right != null){
            helper(root.right,sum-root.val,temp);
            temp.remove(temp.size()-1);
        }    
    }
}