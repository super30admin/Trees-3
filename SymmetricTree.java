// Time Complexity : O(n)
// Space Complexity : O(n)
class SymmetricTree {
	static class TreeNode {	
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
	}
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode left, TreeNode right) {
		//base
		if(left==null && right== null) return true;
		if(left==null || right==null || left.val != right.val) return false;
		
		//logic
		return isMirror(left.left, right.right) && isMirror(left.right, right.left);
	}

	// Driver code to test above 
    public static void main(String args[]) {
    	SymmetricTree ob = new SymmetricTree();
    	TreeNode root= new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));	
    	
		System.out.print("Is tree symmetric : "+ ob.isSymmetric(root));		
    } 
}