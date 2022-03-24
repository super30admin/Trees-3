// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    //     boolean flag;
    //     private void helper(TreeNode left, TreeNode right){
    //         //base
    //         if(left == null && right == null)return;
    //         if(left == null || right == null || left.val!=right.val){
    //             flag = false;
    //             return;
    //         }
                
    //         //logic
    //         if(left!=null && right!=null){
    //             helper(left.left, right.right);
    //         }
    //         helper(left.right, right.left);
            
    //     }
    //     public boolean isSymmetric(TreeNode root) {
    //         flag = true;
    //         if(root == null) return flag;
    //         helper(root.left, root.right);
    //         return flag;
    //     }
        
        //method2
        private boolean helper(TreeNode left, TreeNode right){
            //base
            if(left == null && right == null)return true;
            if(left == null || right == null || left.val!=right.val){
                return false;
            }
                
            //logic
            return helper(left.left, right.right)&& helper(left.right, right.left);
            
        }
        public boolean isSymmetric(TreeNode root) {
            //flag = true;
            if(root == null) return true;
            return helper(root.left, root.right);
         
        }
        // //method3
    
        // public boolean isSymmetric(TreeNode root) {
        //     if(root == null)return true;
        //     Stack<TreeNode> st = new Stack<>();
        //     st.add(root.left);
        //     st.add(root.right);
        //     while(!st.isEmpty()){
        //         TreeNode right =st.pop();
        //         TreeNode left = st.pop();
        //         if(left == null && right == null) continue;
        //         if(left == null || right == null || left.val!=right.val) return false;
        //         st.add(left.left);
        //         st.add(right.right);
        //          st.add(left.right);
        //          st.add(right.left);
                
        //     }
        //      return true;
        //}
    }