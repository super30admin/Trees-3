/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
 * There are multiple ways of approaching this problem. but the idea behind all the approaches is pretty much the same. As we are trying to find symmetricity around the corner, we will compare rights right with lefts left and lefts right with rights left. 

 Approach 1: 
 - Do a level order traversal, using a queue. 
 - If either of the mirrored nodes are null, return false or if the value of either of mirror nodes is not equal, return false 
 */
 //TC: O(n) -> iterate through all the nodes in the tree
 // SC:O(n) -> maintaining queue for elements on each level 
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
 
            if(left == null && right == null)
                continue;
            if(left == null || right == null)
                return false;

            if(left.val != right.val)
                return false;
            
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
            
        }
        return true;
    }
}



/* Approach 2: Use stack instead of queue and keep the approach similar 
 //TC: O(n) -> iterate through all the nodes in the tree
 // SC:O(n) -> maintaining stack for elements on each level 
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> st = new Stack<>();

        st.add(root.left);
        st.add(root.right);

        while(!st.isEmpty()){
            TreeNode left = st.pop();
            TreeNode right = st.pop();

            if(left == null && right == null)
                continue;
            if(left == null || right == null)
                return false;
            if(left.val != right.val){
                return false;
            }

            st.add(left.left);
            st.add(right.right);
            st.add(left.right);
            st.add(right.left);
        }
        return true;
    }
}




  /*
 * Approach 3: Use recursion stack to store nodes for comparison
 *  //TC: O(n) -> iterate through all the nodes in the tree
 // SC:O(n) -> maintaining stack for elements on each level 
  */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        
        //logic
        boolean l = helper(left.left, right.right);
        boolean r = helper(left.right, right.left);

        return l && r;
    }
}