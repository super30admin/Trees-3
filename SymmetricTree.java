//TC: O(N) traverse the tree once. N - no of nodes in tree
///SC: O(N) Linear tree will have height = N. Hence O(N) Space complexity.

//Recursive approach
//The roots of tree should be equal.
//The left tree should be mirror of right subtree.
//Hence we compare left node of left tree with right node of right tree and right node of left tree with left node of right tree.
//If the values are unequal, tree is not symmetric.

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

public class SymmetricTree {
    
    public static boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return isMirror(root, root);

    }

    private static boolean isMirror(TreeNode node1, TreeNode node2){

        //Base Case
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;

        //Logic
        if(node1.val != node2.val) return false;

        //Recursion Call
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(22);
        root.left.left = new TreeNode(17);
        root.right.left = new TreeNode(22);
        

        System.out.println(isSymmetric(root));
    }
}
