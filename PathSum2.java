// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - Perform DFS traversal.
//    - Maintain a running path and current sum as you traverse the tree.
//    - When you reach a leaf node, check if the current sum equals the target sum.
//    - If yes, add a copy of the current path to the result.
//    - Backtrack by removing the last element from the path after recursive calls.

import java.util.ArrayList;
import java.util.List;

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
public class PathSum2 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    // private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
    //     if(root == null) {
    //         return;
    //     }
    //     currSum += root.val;
    //     List<Integer> temp = new ArrayList<>(path); //create deep copy of previous path and don't touch parent path list
    //     temp.add(root.val);

    //     if(root.left == null && root.right == null) {
    //         //leaf node so check if targetSum == currSum
    //         if(currSum == targetSum) {
    //             result.add(temp);
    //         }
    //     }

    //     //traverse through left and right subtree but pass temp as a new parent path
    //     helper(root.left, targetSum, currSum, temp);

    //     helper(root.right, targetSum, currSum, temp);
    // }

    //TC - O(n) since single list for al nodes created just nodes are added and removed
//SC - O(h) for path list + O(h) no of stacks
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if(root == null) {
            return;
        }

        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(targetSum == currSum) {
                result.add(new ArrayList<>(path));
            }
        }

        //recurse
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        //backtrack
        path.removeLast();  //remove last element in list
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null
                ),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, null, new TreeNode(1))
                )
        );

        PathSum2 solver = new PathSum2();
        List<List<Integer>> paths = solver.pathSum(root, 22);

        System.out.println("Paths that sum to 22:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
