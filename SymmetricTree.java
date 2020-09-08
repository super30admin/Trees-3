// TC: O(N) where N represents the nodes in the tree.
// SC: O(H) for recursion stack storing left and right subtree of the tree.

// We are keeping 2 copies of the Tree so that we can check the right subtree of the  one tree with the left subtree of second tree. 
// Since we know the symmetry means they should form mirror reflection, the left values of right subtree should match with right values of left subtree.
// if the values does not match, we return false, Also, we return false if the left subtree has null and right subtree does not have null values.
// We repeat this process on both the sides of the subtree with 2 different copies of the tree.


public class SymmetricTree {

	public boolean Symmetric(TreeNode root) {
		return Symmetry(root, root);
	}
	
	public boolean Symmetry(TreeNode r1, TreeNode r2) {
		if(r1==null && r2==null)
			return true;
		if(r1== null || r2==null)
			return false;
		
		if(r1.val!=r2.val)
			return false;
		return Symmetry(r1.left, r2.right) && Symmetry(r1.right, r2.left);
	}
	
	public static void main(String[] args) {
		
		SymmetricTree st = new SymmetricTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = null;
		root.left.right = new TreeNode(3);
		root.right.left = null;
		root.right.right = new TreeNode(3);
		
		System.out.println(st.Symmetric(root));
	}
}
