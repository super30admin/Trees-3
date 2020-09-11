// Time Complexity : O(n) since we are traversing each node once
// Space Complexity :O(H) due to recursive call + O(c*H) where h is height(length of the ans) and c is no of the answerss
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//  the helper takes in params it has to pass recuresively every time which are
// root(current node),curSum (cursum at that level) ,sum(target), output variable, and pathSoFar(path before reaching the current node)
// but since arrays as passed by reference hence we first add the current node to pathSoFar run helper recursively for left and right branch and,
// when we are done with the current node we remove the current node from pathSoFar and go to the parent of this current node so that he doesnt alter the path sofar
// ***all the recursive calls have same copy of pathSoFar***List and path are passed by reference
// we add current val to curSum..if curSum reaches target(sum)and we are at leaf node,we have to add this..
// but due to pass by reference prob, we make a new temp list using this pathsofar,add the current node add temp list to output list

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        // if the root is null return empty ArrayList
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> pathSoFar = new ArrayList();
        helper(root, pathSoFar, 0, sum, output);

        return output;

    }

    private void helper(TreeNode root, List<Integer> pathSoFar, int curSum, int sum, List<List<Integer>> output) {

        if (root == null)
            return;
        curSum = curSum + root.val;

        if (root.left == null && root.right == null && sum == curSum) {
            List<Integer> temp = new ArrayList<Integer>(pathSoFar);
            temp.add(root.val);
            output.add(temp);
        }
        pathSoFar.add(root.val);
        helper(root.left, pathSoFar, curSum, sum, output);
        helper(root.right, pathSoFar, curSum, sum, output);
        pathSoFar.remove(pathSoFar.size() - 1);

    }
}