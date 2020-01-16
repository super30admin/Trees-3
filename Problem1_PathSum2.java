/************* Time Complexity : O(n) ************/
/************* Space Complexity : O(n) ************/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> resultList = new ArrayList<>();         // resultant list
        List<Integer> currentList = new ArrayList<>();              //each list in the resultant
        depthSearchSum(root, currentList, resultList, sum);         //recursively calling dfs to find sum and compare
        return resultList;
    }
    
    private void depthSearchSum(TreeNode root, List<Integer> currentList, List<List<Integer>> resultList, int sum){
        //base case
        if(root == null)
            return;
        
        //add 1st node to the current list for further steps
        currentList.add(root.val);
        
        //if its a leaf node
        //check if the given sum is equal to the current sum -> return
        if(root.left == null && root.right == null){
            if(sum == root.val){
                resultList.add(new ArrayList<>(currentList));
                return;
            }
        }
        
        //if left of root is not empty
        //recursively check sum
        //subtract the current node from current list (backtrack)
        if(root.left != null){
            depthSearchSum(root.left, currentList, resultList, sum - root.val);
            currentList.remove(currentList.size()-1);
        }
        
        //if right of root is not empty
        //recursively check sum
        //subtract the current node from current list (backtrack)
        if(root.right != null){
            depthSearchSum(root.right, currentList, resultList, sum - root.val);
            currentList.remove(currentList.size()-1);
        }
    }
}