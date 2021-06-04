package Tree1;

import java.util.ArrayList;
import java.util.List;

/*S30 Big N Problem #47 {Medium} - https://www.youtube.com/watch?v=ZfYtnUTI7WE

you are given a binary tree and a total sum, you have to tell the root-to-leaf paths whre path's sum is going to be the same as the given total value. 
assume leaf node is the one with no children.
Example:
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
  /  \    / \
 7    2  5   1

Return:
[[5,4,11,2],
 [5,8,4,5]] 
Source Link: https://leetcode.com/problems/path-sum-ii/
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
