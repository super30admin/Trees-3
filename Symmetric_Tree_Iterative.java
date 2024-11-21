import java.util.Stack;

public class Symmetric_Tree_Iterative {
	
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        
        while(!stack.isEmpty()){
            
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            
            if(right == null && left == null){
                continue;
            }
            
            if(right == null || left == null){
                return false;
            }
            
            if(right.val != left.val){
                return false;
            }
            
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        
        return true;
    }

}
