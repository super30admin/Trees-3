// Time Complexity :O(n) n-number of nodes
// Space Complexity :O(h) h- maximum height of the tree 
// Did this code successfully run on Leetcode :yes 
//recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }
    
    private boolean helper (TreeNode left,TreeNode right)
    {
        if(left==null && right==null) return true;
        
        if(left==null || right==null || left.val!=right.val) return false;
        
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
//Iterative approach
/*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        if(root==null) return true;
        st.push(root.right);
        st.push(root.left);
        
        while(!st.isEmpty())
        {
            TreeNode left=st.pop();
            TreeNode right=st.pop();
            if(left==null && right==null) continue;
            if(left==null || right==null || left.val!=right.val) return false;
            st.push(right.right);st.push(left.left);
            st.push(right.left);st.push(left.right);
 
        }
        return true;
 */
  
/*
//Inorder traversal

class Solution {
    List<Integer> list1=new ArrayList<Integer>();
    List<Integer> list2=new ArrayList<Integer>();
    
    public boolean isSymmetric(TreeNode root) {
        helper1(root);
        helper2(root);
        System.out.println(list1);
        System.out.println(list2); 
        return list1.equals(list2);
    }
    private void helper1(TreeNode root)
    {
        if(root==null) 
        {
           list1.add(null);
            return;
        }
        
        list1.add(root.val);
        
        if(root.right==null && root.left==null)
            return;
        
        

        helper1(root.left);
        helper1(root.right);

        
    }
    
    private void helper2(TreeNode root)
    {

        if(root==null) 
        {
            list2.add(null);
            return;
        }
        
        list2.add(root.val);
        
        if(root.right==null && root.left==null)
            return;
        

        helper2(root.right); 
        helper2(root.left);
        
    }
*/