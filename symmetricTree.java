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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        int s=0;
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode t=null;
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
             s=q.size();
             String s1="";
             String s2="";
            for(int i=0;i<(s/2);i++){
               t=q.poll();
               if(t!=null){
                //if(t.left!=null)
                q.offer(t.left);
                //if(t.right!=null)
                q.offer(t.right);
               }
               if(t==null)

                s1=s1+'*';   
                else 
                s1=s1+t.val;  
                
            }for(int i=0;i<(s/2);i++){
               t=q.poll();
                if(t!=null){
                //if(t.left!=null)
                q.offer(t.left);
                //if(t.right!=null)
                q.offer(t.right);
               }
                if(t==null)

                s2='*'+s2;   
                else 
                s2=t.val+s2; 
            }
            System.out.println(s1);
            System.out.println(s2);
            if(!s1.equals(s2))
               return false;
       
        
        }
        return true;
        
        
    }
}
