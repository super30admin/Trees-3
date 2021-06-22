package Trees3;

import java.util.ArrayList;
import java.util.List;

/*Source Link: https://leetcode.com/problems/path-sum-ii/
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(n*n) - n*n is the number of elements in tree
    space complexity: o(n*h) - create a new arraylist for each recursive call. and each list size is Height of the tree. 
    Did this code run successfully in leetcode : yes
    problems faces : no
    */
public class pathSumToTarget {

    List<List<Integer>> pathSumList = new ArrayList<>();
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int currentSum = 0;
        target = targetSum;
        List<Integer> elementsList = new ArrayList<>();
        inorder(root, elementsList, currentSum);
        return pathSumList;
    }

    public void inorder(TreeNode root, List<Integer> elementsList, int currentSum) {

        if (root == null)
            return;

        currentSum = currentSum + root.val;
        elementsList.add(root.val);

        if (root.left == null && root.right == null && currentSum == target) {
            pathSumList.add(new ArrayList<>(elementsList));

        }

        inorder(root.left, new ArrayList<>(elementsList), currentSum);
        inorder(root.right, new ArrayList<>(elementsList), currentSum);

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
}
