// Time Complexity : O(n) where n is total nodes in the tree
// Space Complexity : O(n) where n is total nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(a!= null && b!=null){
            if(a.val == b.val){
                return helper(a.left, b.right) && helper(a.right, b.left);
        }
        return false;
    }

    //iterative
    public boolean isSymmetricIterative(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack();
        stack.push(root.left);stack.push(root.right);
        
        while(!stack.isEmpty()){
            TreeNode r = stack.pop();
            TreeNode l = stack.pop();
            
            if(r == null && l == null) continue;
            
            if(r != null && l!=null){
                if(r.val == l.val){
                    stack.push(l.left);
                    stack.push(r.right);
                    stack.push(l.right);
                    stack.push(r.left);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
