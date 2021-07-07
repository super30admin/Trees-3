/**
Time complexity: O(N^2) => N/2 leaf nodes, copying list from tempList into result for each leaf is O(N)=> So, O(N^2)
Space complexity: O(N) for temporary list
Algorithm: 
=========
1. Use temporary array list to update nodes on current path. 
2. If leaf node and currSum is equal to node value, that means path is found. So, copy values from tempList to new arraylist in result
3. Now, call this method on root.left and root.right and backtrack and delete last node of the temporary list to reuse for next subtree
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();                 // temporary list to keep track of path in DFS
        recurseTree(root, sum, tempList);                           
        return result;
    }
    
    private void recurseTree(TreeNode root, int remainingSum, List<Integer> tempList) {
        //base
        if(root == null)  return;
        
        //logic
        tempList.add(root.val);
        if(remainingSum == root.val && root.left == null && root.right == null)         //Path with the target sum found
            result.add(new ArrayList<>(tempList));
        else {
            recurseTree(root.left, remainingSum - root.val, tempList);                  // check for pathsum in left subtree
            recurseTree(root.right, remainingSum - root.val, tempList);                 // check for pathsum in right subtree
        }
        tempList.remove(tempList.size()-1);
        return;
    }
}