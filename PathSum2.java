// TC --> Brute Force O(n^2)
// SC --> Brute Force O(n^2)

import java.util.*;

public class PathSum2 {

    public static class TreeNode {
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

    // Brute Force
    public static class Solution1 {
        List<List<Integer>> result;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();
            helper(root,0,new ArrayList<>(),targetSum);
            return result;
        }
        private void helper(TreeNode root, int curSum,List<Integer> path, int targetSum){
            if(root==null) return;

            curSum+=root.val;
            List<Integer> temp = new ArrayList<>(path);
            temp.add(root.val);
            //check for leaf node
            if(root.left==null && root.right==null){
                if(curSum==targetSum) result.add(temp);
            }
            helper(root.left,curSum,temp,targetSum);
            helper(root.right,curSum,temp,targetSum);
        }
    }

    // Optimized - Backtracking solution
    public static class Solution2 {
        List<List<Integer>> result;
        List<Integer> path;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();
            path = new ArrayList<>();
            helper(root,0,targetSum);
            return result;
        }
        private void helper(TreeNode root, int curSum, int targetSum){
            if(root==null) return;
            curSum+=root.val;

            path.add(root.val);
            //check for leaf node
            if(root.left==null && root.right==null){
                if(curSum==targetSum) result.add(new ArrayList<>(path));
            }

            //Recursive calls
            helper(root.left,curSum,targetSum);
            helper(root.right,curSum,targetSum);

            //backtracking step - very important
            path.remove(path.size()-1);
        }
    }
}
