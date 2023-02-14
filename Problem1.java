import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Find Paths whose sum is equal to target
approach: traverse through all paths to check if target= sum, if yes, add to result, no, backtrack
time: O(n)
space: (height)
 */
class TreeNode {
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

public class Problem1 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Stack<Integer> stack = new Stack<>();
        helper(root, targetSum, stack, 0);
        return result;
    }

    static void helper(TreeNode root, int target, Stack<Integer> stack, int sum) {
        if(root!=null) {
            stack.push(root.val);
            sum = sum+root.val;
            if(root.left==null && root.right==null) {
                if(target==sum) {
                    result.add(new ArrayList<>(stack));
                }
                stack.pop();
                return;
            }
            helper(root.left, target, stack, sum);
            helper(root.right, target, stack, sum);
            stack.pop();
        }
    }
    public static void main(String []args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node2.left = node4;
        node4.left = node7;
        node4.right = node8;
        node1.right = node3;
        node3.left = node5;
        node3.right = node6;
        node6.left = node9;
        node6.right = node10;
        pathSum(node1, 22);
    }
}
