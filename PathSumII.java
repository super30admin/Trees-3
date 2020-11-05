// Time Complexity : O(n) where m=no. of nodes in the tree
// Space Complexity : O(1) no extra auxiliary space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * We will be using recursion techniques to solve the problem. We will be visiting the each node and maintaining the
 * current sum to that node from the root and list of the nodes from the root to that node.
 * To optimize the solution, we will use backtracking approach to update the list which avoids in creating
 * new list at each node improving time and space complexity
 * */


import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> result;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        if(root==null) return result;
        helper(root, 0, new ArrayList<Integer>());
        return result;

    }
    //using recursion and the extra space
    //Time  = O(n^2) since we create new list at each node
    //Space = O(n) creating new list at each node
   /* private void helper(TreeNode root, int curSum, List<Integer> list) {
        //base
        if(root==null) return;

        //logic
        curSum += root.val;
        List newList = new ArrayList(list);
        newList.add(root.val);
        if(curSum==target && root.left==null && root.right==null){

            result.add(newList);
        }
        helper(root.left, curSum, newList );
        helper(root.right, curSum, newList);
    }*/

    //Optimal solution using backtracking
    private void helper(TreeNode root, int curSum, List<Integer> list){
        //base
        if(root==null) return;

        //logic
        curSum += root.val;
        list.add(root.val);
        if(curSum==target && root.left==null && root.right==null){
            result.add(new ArrayList<>(list));
        }
        helper(root.left, curSum, list);
        helper(root.right, curSum, list);
        list.remove(list.size()-1);
    }

}

class TreeNode {
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
