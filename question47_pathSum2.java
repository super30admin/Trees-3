package Trees3;

import java.util.ArrayList;
import java.util.List;

public class question47_pathSum2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val)
        {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
        Time Complexity: O(n ^ 2)
        Space Complexity: O(n ^ 2)
    */
    List<List<Integer>> list;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new ArrayList<>();
        target = targetSum;
        if(root == null) return list;
        helper(root, 0, new ArrayList<>());
        return list;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path) {
        if(root == null) return;
        currSum += root.val;
        path.add(root.val);
        helper(root.left, currSum, new ArrayList<>(path));
        //root = st.pop()[0]; currSum = st.pop()[1]; path = st.pop()[2];

        if(root.left == null && root.right == null) {
            if(target == currSum) {
                list.add(path);
            }
        }
        helper(root.right, currSum, new ArrayList<>(path));
    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    List<List<Integer>> listOpt;
    int targetOpt;
    public List<List<Integer>> pathSumOpt(TreeNode root, int targetSum) {
        listOpt = new ArrayList<>();
        targetOpt = targetSum;
        if(root == null) return listOpt;
        helperOpt(root, 0, new ArrayList<>());
        return listOpt;
    }
    private void helperOpt(TreeNode root, int currSum, List<Integer> path) {
        //Base
        if(root == null) return;

        //Logic
        //Action
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(targetOpt == currSum) {
                listOpt.add(new ArrayList<>(path));
            }
        }
        //Recursion
        helperOpt(root.left, currSum, path);
        //root = st.pop()[0]; currSum = st.pop()[1]; path = st.pop()[2];


        helperOpt(root.right, currSum, path);
        //Backtracking
        path.remove(path.size() - 1); // O(1)
    }

    public static void main(String[] args) {

    }
}
