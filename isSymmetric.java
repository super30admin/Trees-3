package trees;

public class isSymmetric {
	public boolean isSymmetric(TreeNode root) {
        return verify(root,root);
        
    }
    public Boolean verify(TreeNode node1,TreeNode node2){
            if(node1==null && node2== null) return true;
        if(node1==null || node2== null) return false;
                return (node1.val== node2.val) && verify(node1.right,node2.left) && verify(node1.left,node2.right);
            }

}
