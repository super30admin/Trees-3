time complexity: O(n)
space complexity: O(h)

class Solution { 
    public boolean isSymmetric(TreeNode root) {
      if (root == null) //initial base condition
		return true;
	return isSymmetric(root.left, root.right); //recursive call
}
 
public boolean isSymmetric(TreeNode l, TreeNode r) {
	if (l == null && r == null) { //checking if the values are not equal
		return true;
	} else if (r == null || l == null) {
		return false;
	}
 
	if (l.val != r.val) //not equal, then return false
		return false;
 
	if (!isSymmetric(l.left, r.right))
		return false;
	if (!isSymmetric(l.right, r.left))
		return false;
 
	return true;  
    }
}