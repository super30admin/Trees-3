import java.util.Stack;

//revursive
// Time Complexity : O(n) n is the number of nodes
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :N

//iterative
// Time Complexity : O(n) n is the number of nodes
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :N

public class SymmetricTree {
    Stack<TreeNode> leftStack ;
      Stack<TreeNode> rightStack ;
    public boolean isSymmetric(TreeNode root) {
        this.leftStack = new Stack<>();
         this.rightStack = new Stack<>();
        //return helper(root.left, root.right);
        return helper1(root);
    }

    //recursive
    public boolean helper(TreeNode left, TreeNode right)
    {
        //base
        if(left == right)
        {
            return true;
        }

        if(left == null || right == null || left.val != right.val)
        {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    //iterative
    public boolean helper1(TreeNode root) {
    if (root == null) {
        return true;
    }

    Stack<TreeNode> leftStack = new Stack<>();
    Stack<TreeNode> rightStack = new Stack<>();

    leftStack.push(root.left);
    rightStack.push(root.right);

    while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
        TreeNode leftNode = leftStack.pop();
        TreeNode rightNode = rightStack.pop();

        if (leftNode == null && rightNode == null) {
            continue;
        }

        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }

        leftStack.push(leftNode.left);
        leftStack.push(leftNode.right);

        rightStack.push(rightNode.right);
        rightStack.push(rightNode.left);
    }

    return true;
}

public static void main(String [] args)
    {
        SymmetricTree bst = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
  

        // Function call
        System.out.println(bst.isSymmetric(root));
    }
}
