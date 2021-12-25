
public class Symmetric {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		     }
	
	public boolean help(TreeNode l, TreeNode r){
        if(l==null && r==null){return true;}
       else if(l==null&& r!=null){return false;}
       else if (l!=null&& r==null){return false;}
        
        if(l.val==r.val){
            
            boolean a=help(l.left,r.right);
            boolean b=help(l.right,r.left);
        return (a&&b);
        }else{
            
            return false;
        }
        
    }
    public boolean isSymmetric(TreeNode root) {
     
        if(root==null){return false;}
        return help(root.left, root.right);   
    }
	}}
