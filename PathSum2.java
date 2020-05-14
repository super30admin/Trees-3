// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Maintaining the local list to get it as a result correctly.
/* Your code here along with comments explaining your approach: Sum along/ running sum each node value as you move towards the leaf. Capture your path while you are
moving to the leaf. If you have reached the leaf node, check if the sum you got matches the target sum, if yes then create a new list to put your
path copy in the result. As you backtrack, remove the last node encountered from the path you have till now, as they have been processed already and 
you have checked the sum.
*/
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> temp = new ArrayList<>();
        sumCheck(root, sum, temp, 0);
        return result;
    }
    private void sumCheck(TreeNode root, int sum, List<Integer> temp, int currentSum){
        if(root == null){return;}                                                           // base case
        currentSum+=root.val;                                                               //Running sum
        temp.add(root.val);                                                                 // Adding nodes to the path
        if(root.left == null && root.right == null){                                        // if leaf node
            if(sum == currentSum){
            result.add(new ArrayList<Integer>(temp));                                   // Add the path you got that matches the sum
            }
        }
        sumCheck(root.left, sum, temp, currentSum);
        sumCheck(root.right, sum, temp, currentSum);
        temp.remove(temp.size()-1);                                                 // as you backtrack, remove the nodes as they have been processed already
    }
}