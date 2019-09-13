//Approach 1: Recursive
//Time complexity:O(N)
//Space Complexity:O(N)
//In this problem, I'll create a helper function, which will check if my left and the right node are equal. If any of them are null, I'll return null. I'll then recursively check, If my left most node is equal to the right most node. In that case, I'll return true. Otherwise, I'll return false.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public boolean isSymmetric(TreeNode root) {
       
      
        return helper(root,root);
    }
    private boolean helper(TreeNode root1, TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        return(root1.val==root2.val)&&helper(root1.left,root2.right)&&helper(root1.right,root2.left);
    }
}
//Approach 2: Iterative
//Time complexity:O(N)
//Space Complexity:O(N)
//In this problem,I'll be creating a queue, which will hold my left and the right element. When the queue is not empty, I'll pick the top 2 elements in the queue and then check if they are equal. If either of them are null or their values are not equal, I'll be returning false. Else, I'll append the leftmost and the rightmost node elements and the right aand the left elements in the middle and then check the same until the queue becomes empty.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t1=q.poll();
            TreeNode t2=q.poll();
            if(t1==null&&t2==null){
                continue;
            }
            if(t1==null||t2==null){
                return false;
            }
            if(t1.val!=t2.val){
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t2.left);
            q.add(t1.right);
            
        }
        return true;
    }
}