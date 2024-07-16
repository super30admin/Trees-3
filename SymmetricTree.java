import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true; //if empty tree

        return isSymmetricRecursion(root.left, root.right); //recurse on the children of given root
    }

    static boolean isSymmetricRecursion(TreeNode left, TreeNode right) { //O(n) T.C, O(1) S.C
        if(left == null && right == null) return true; //if nodes on both sides are covered and equal
        if(left == null || right == null) return false; //if nodes on either side is covered while other is not
        if(left.val != right.val) return false; //if the mirrored values are not same

        //perform on mirrored sides
        return isSymmetricRecursion(left.left, right.right) && //left child of left root and right child of right root
                isSymmetricRecursion(right.left, left.right); //left child of right root and right child of left root
    }

    public static void main(String[] args) {
        // Example test case
        Integer[] values = {1, 2, 2, 3, 4, 4, 3};  // Symmetric tree

        // Create the tree from the array
        TreeNode root = createTree(values);

        // Create an instance of the solution and test
        boolean result = isSymmetric(root);

        // Print the result
        System.out.println("Is the tree symmetric? " + result);
    }

    public static TreeNode createTree(Integer[] values) {
        if (values.length == 0) return null;
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}
