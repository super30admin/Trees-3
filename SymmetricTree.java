class SymmetricTree {
    // Method 1 - Iterative approach
    // Time complexity O(n)
    //Space Complexity O(n)
    // Tested in leetcode

   public boolean isSymmetric(TreeNode root) {
       if(root == null)
           return true;
  
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       queue.offer(root);
       
       while(!queue.isEmpty()){
           TreeNode node1 = queue.poll();
           TreeNode node2 = queue.poll();
           
           // check both nodes are null
           if(node1 == null && node2 == null)
               continue;
           //return false if any one node is null
           if(node1 == null || node2 == null)
               return false;
           
           //return false if values of both node are not equal
           if(node1.val != node2.val)
               return false;
           
           queue.offer(node1.left);
           queue.offer(node2.right);
           queue.offer(node1.right);
           queue.offer(node2.left);
       }
       return true;
   }
   
   
   // Method 2 - Using Recursion
    // Time complexity O(n)
    // Space Complexity O(n)due to recursive call on the stack
    // Tested in leetcode
   public boolean isSymmetric2(TreeNode root) {
       if(root == null)
           return true;
       return helperRecursion(root.left, root.right);
   }
   // Helper function of Method 2
   public boolean helperRecursion(TreeNode left, TreeNode right){
       // return true if both nodes are null
       if(left == null && right == null)
           return true;
       //return false if any one node is null
       if(left == null || right == null)
           return false;
       return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
   }
   
  
}