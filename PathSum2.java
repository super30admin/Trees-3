// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we will do an inorder traversal through the tree,adding the nodes of the path to a temp array
//and at the end of every leaf node we take the sum of that path
//and compare to the total sum, and add to result array if it is a valid path

public class PathSum2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> temp = new ArrayList<>();
        if(root == null) return result;
        helper(root, temp, sum, 0);
        return result;


    }

    public void helper(TreeNode root, List<Integer> temp, int sum, int currSum){
        if(root == null) return;

        //add to temp path and sum
        temp.add(root.val);
        currSum += root.val;

        if(root.left == null && root.right == null){
            //if correct amt add the path to result array
            if(currSum == sum){
                result.add(new ArrayList<>(temp));
            }
        }

        helper(root.left, temp, sum, currSum);
        helper(root.right, temp, sum, currSum);

        //remove the leaf node from temp the same way we pop from stack in order to allow backtracking
        temp.remove(temp.size() - 1);
    }
}