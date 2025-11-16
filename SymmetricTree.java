
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null))
            return false;
        if (root.left.val != root.right.val)
            return false;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode leftTree, TreeNode rightTree) {
        if(leftTree == null &&  rightTree == null) {
            return true;
        }

        if ((leftTree.right == null && rightTree.left != null) || (leftTree.left == null && rightTree.right != null)) {
            return false;
        }

        if ((leftTree.right != null && rightTree.left == null) || (leftTree.left != null && rightTree.right == null)) {
            return false;
        }

        if ((leftTree.right == null && rightTree.left == null || leftTree.right.val == rightTree.left.val)
                && (leftTree.left == null && rightTree.right == null || leftTree.left.val == rightTree.right.val)) {
            return helper(leftTree.left, rightTree.right) && helper(leftTree.right, rightTree.left);
        } else {
            return false;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // input: root = [1,2,2,3,4,4,3]
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = symmetricTree.new TreeNode(1);
        root.left = symmetricTree.new TreeNode(2);
        root.right = symmetricTree.new TreeNode(2);
        root.left.left = symmetricTree.new TreeNode(3);
        root.left.right = symmetricTree.new TreeNode(4);
        root.right.left = symmetricTree.new TreeNode(4);
        root.right.right = symmetricTree.new TreeNode(3);
        boolean result = symmetricTree.isSymmetric(root);
        System.out.println(result);

        // input: root = [1,2,2,null,3,null,3]
        TreeNode root2 = symmetricTree.new TreeNode(1);
        root2.left = symmetricTree.new TreeNode(2);
        root2.right = symmetricTree.new TreeNode(2);
        root2.left.right = symmetricTree.new TreeNode(3);
        root2.right.right = symmetricTree.new TreeNode(3);
        boolean result2 = symmetricTree.isSymmetric(root2);
        System.out.println(result2);

        // input: root = []
        TreeNode root3 = null;
        boolean result3 = symmetricTree.isSymmetric(root3);
        System.out.println(result3);

        // input: root = [1]
        TreeNode root4 = symmetricTree.new TreeNode(1);
        boolean result4 = symmetricTree.isSymmetric(root4);
        System.out.println(result4);

        // level 4 tree
        TreeNode root5 = symmetricTree.new TreeNode(1);
        root5.left = symmetricTree.new TreeNode(2);
        root5.right = symmetricTree.new TreeNode(2);
        root5.left.left = symmetricTree.new TreeNode(3);
        root5.left.right = symmetricTree.new TreeNode(4);
        root5.right.left = symmetricTree.new TreeNode(4);
        root5.right.right = symmetricTree.new TreeNode(3);
        root5.left.left.left = symmetricTree.new TreeNode(5);
        root5.left.left.right = symmetricTree.new TreeNode(6);
        root5.right.right.left = symmetricTree.new TreeNode(6);
        root5.right.right.right = symmetricTree.new TreeNode(5);
        boolean result5 = symmetricTree.isSymmetric(root5);
        System.out.println(result5);

        // level 4 tree - not symmetric
        TreeNode root6 = symmetricTree.new TreeNode(1);
        root6.left = symmetricTree.new TreeNode(2);
        root6.right = symmetricTree.new TreeNode(2);
        root6.left.left = symmetricTree.new TreeNode(3);
        root6.left.right = symmetricTree.new TreeNode(4);
        root6.right.left = symmetricTree.new TreeNode(4);
        root6.right.right = symmetricTree.new TreeNode(3);
        root6.left.left.left = symmetricTree.new TreeNode(5);
        root6.left.left.right = symmetricTree.new TreeNode(6);
        root6.right.right.left = symmetricTree.new TreeNode(7);
        root6.right.right.right = symmetricTree.new TreeNode(5);
        boolean result6 = symmetricTree.isSymmetric(root6);
        System.out.println(result6);

        // [5,2,2,4,null,null,1,null,1,null,4,2,null,2,null]
        TreeNode root7 = symmetricTree.new TreeNode(5);
        root7.left = symmetricTree.new TreeNode(2);
        root7.right = symmetricTree.new TreeNode(2);
        root7.left.left = symmetricTree.new TreeNode(4);
        root7.right.right = symmetricTree.new TreeNode(1);
        root7.left.left.right = symmetricTree.new TreeNode(1);
        root7.right.right.left = symmetricTree.new TreeNode(4);
        root7.right.right.left.left = symmetricTree.new TreeNode(2);
        root7.right.right.left.right = symmetricTree.new TreeNode(2);
        boolean result7 = symmetricTree.isSymmetric(root7);
        System.out.println(result7);

           // [5,2,2,4,null,null,4,null,1,null,1,2,null,2,null]
        root7 = symmetricTree.new TreeNode(5);
        root7.left = symmetricTree.new TreeNode(2);
        root7.right = symmetricTree.new TreeNode(2);
        root7.left.left = symmetricTree.new TreeNode(4);
        root7.right.right = symmetricTree.new TreeNode(4);
        root7.left.left.right = symmetricTree.new TreeNode(1);
        root7.right.right.left = symmetricTree.new TreeNode(1); 
        root7.right.right.left.left = symmetricTree.new TreeNode(2);
        root7.right.right.left.right = symmetricTree.new TreeNode(2);
        result7 = symmetricTree.isSymmetric(root7);
        System.out.println(result7);

    }

}
