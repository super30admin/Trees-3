import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        // Define the target sum
        int targetSum = 22;

        // Create an instance of pathSum
        pathSum pathSumObj = new pathSum();

        // Calculate and print all root-to-leaf paths with the target sum
        List<List<Integer>> result = pathSumObj.pathSum(root, targetSum);

        // Print the result
        System.out.println("All root-to-leaf paths with sum " + targetSum + ":");
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
