/**
 *
 *  Time Complexity: O(N) Where N is the number of nodes in the tree.
 *  Space Complexity: O(N) It would take O(N) space in worst case(linear tree) and log(N) space in averge case, where log(N) represent height of the tree.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Explanation: We can use backtraking to check all the combinations of values. In backtracking in addition to targetSum and current node, we maintain the current sum and list of nodes from parent to that node. Now for every recursive call we add the current node to the list and check if it is a leaf node and the current sum is equal to target sum then we add the list to the result list. Else we call backtracing to left and right nodes. Now when both the left and right trees are verified we then remove the current node from the list and return to the parent call to check other combinations.  
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root==null) return result;    
        backtracking(root, targetSum, 0, new ArrayList<>());
        return result;
    }
    
    private void backtracking(TreeNode root, int targetSum, int currSum, List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        
        if(root.left!=null) backtracking(root.left, targetSum, currSum+root.val, list);
        if(root.right!=null) backtracking(root.right, targetSum, currSum+root.val, list);
        if(root.left==null && root.right==null && currSum+root.val==targetSum){
            result.add(new ArrayList<>(list));
        }
        list.remove(list.size()-1);
    }
}
