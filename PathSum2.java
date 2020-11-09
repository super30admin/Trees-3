package S30.Trees_3;

/*
Time Complexity : O(n)[backtracking solution] - touching every node
Space Complexity : O(h)[max length of result = max height of stack frame]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

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

    //Solution with independent lists created for each stackframe
    public List<List<Integer>> pathSumWithArraylistCopies(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        helper(root,sum,result, new ArrayList<Integer>());
        return result;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list){

        if(root == null) return;

        List<Integer> tempList = new ArrayList<>(list);
        tempList.add(root.val);
        if(root.left == null && root.right == null && sum - root.val == 0){
            result.add(tempList);
            return;
        }
        helper(root.left, sum - root.val,result,tempList);
        helper(root.right, sum - root.val, result, tempList);

    }

    //Backtracking solution
    public List<List<Integer>> pathSumWithBacktracking(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        dfs(root,sum,allPaths,new ArrayList<Integer>());
        return allPaths;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> result){

        if(root == null) return;
        result.add(root.val);
        if(root.left == null && root.right == null && sum-root.val == 0){
            allPaths.add(new ArrayList<Integer>(result));
        }

        dfs(root.left,sum-root.val,allPaths,result);
        dfs(root.right,sum-root.val,allPaths,result);
        result.remove(result.size()-1);
    }
}
