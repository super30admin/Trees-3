// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// using BFS : Queue
class Solution {
   
    public boolean isSymmetric(TreeNode root) {
        
         Queue<TreeNode> tree=new LinkedList<>();
          tree.add(root.left);
          tree.add(root.right);
          while(!tree.isEmpty()){
              TreeNode left=tree.poll();
              TreeNode right= tree.poll();
              if(left==null && right==null)
                  continue;
              if(left==null || right==null || left.val!=right.val)
                  return false;
              tree.add(left.left);
              tree.add(right.right);
              tree.add(left.right);
              tree.add(right.left);
          }
          return true;
    }
}

//Using DFS: recursion -> Stack
// Time Complexity : O(n)
// Space Complexity : O(h) stack space
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while(!st.isEmpty()){
              TreeNode left=st.pop();
              TreeNode right= st.pop();
              if(left==null && right==null)
                  continue;
              if(left==null || right==null || left.val!=right.val)
                  return false;
              st.push(left.left);
              st.push(right.right);
              st.push(left.right);
              st.push(right.left);
          }
          return true;
    
}
}
