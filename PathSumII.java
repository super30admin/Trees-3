/***
 1. If root is null, return empty array list, else call recursive function with root, curSum and target as the argument. Maintain global varibles resultList and pathList to store result and intermediate list
 2. In the recursive function, if root is null, then return, otherwise update curSum with curSum + root.val, push current node to the path list
 3. If currentNode is leaf node, compare curSum with target and if both are equal then create new arraylist with the path list and add it to the result.
 Call recursion on root.left and root.right and remove the last added element from the path list.
 TC - O(n), SC - O(h)
 */

import java.util.ArrayList;
import java.util.List;


class PathSumII {

    List<List<Integer>> resultList;
    List<Integer> pathList;


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null)
            return new ArrayList<>();

        resultList = new ArrayList<>();
        pathList = new ArrayList<>();

        dfs(root, 0, targetSum);

        return resultList;

    }

    private void dfs(TreeNode root, int curSum, int targetSum) {
        if(root == null)
            return;

        curSum += root.val;

        //action
        pathList.add(root.val);

        if(root.left == null && root.right == null) {
            if(curSum == targetSum)
                resultList.add(new ArrayList<>(pathList));
        }

        //recurse
        dfs(root.left, curSum, targetSum);
        dfs(root.right, curSum, targetSum);

        //backtrack
        pathList.remove(pathList.size()-1);

    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        int val;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

