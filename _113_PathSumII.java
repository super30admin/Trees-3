// Time Complexity : o(n) n = number of nodes
// Space Complexity :  o(n) n = number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Approach : Recursive approach, preorder traversal, maintain currsum and path list
class Solution {
   List<List<Integer>> res = null;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        pathSum(root, targetSum, 0, new ArrayList<>());
        return res;
    }

    public void pathSum(TreeNode root, int targetSum, int currSum, List<Integer> currList) {

        if(root == null) return;

        currList.add(root.val);
        currSum += root.val;

        if(root.left == null && root.right == null && targetSum == currSum){
            res.add(new ArrayList<>(currList));
        }

        pathSum(root.left, targetSum, currSum, currList);
        pathSum(root.right, targetSum, currSum, currList);

        currSum -= root.val;
        currList.remove(currList.size()-1);
    }
}
