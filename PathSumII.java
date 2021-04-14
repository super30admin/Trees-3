/**Leetcode Question - 113 - Path Sum 2  */
/**Algorithm - Recursion
 * Pass the root, target sum, currsum and a list to the helper function
 * A new arraylist is created at every iteration because the path is passed by reference so if a new ArrayList is not created at every point
 * then the path will keep appending all the elements that it has visited.
 * When targetSum == CurrSum, append the path to the result list
 */
/**TC = O(N)
 * SC = O(N)
 */
public class PathSumII {
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();
            if(root == null){
                return result;
            }
            helper(root, targetSum, 0, new ArrayList<>());
            return result;
        }
        private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){
            //base
            if(root == null){
                return;
            }
            
            //logic
            currSum = currSum + root.val;
            path.add(root.val);
            if((root.right == null && root.left == null) && targetSum == currSum){
                result.add(new ArrayList<>(path));
            }
            helper(root.left, targetSum, currSum, new ArrayList<>(path)); //the new arraylist stores the current snapshot of the path for later referral
            helper(root.right, targetSum, currSum, new ArrayList<>(path));
            
        }
    }
}

/**Optimised Solution - Backtracking
 * The recursive solution created a new ArrayList at every node to store the current path
 * which took up a lot of extra space
 * Backtracking solution creates just one copy of the path and keeps popping the elements which have been visited and both children have been explored
 * The result take the current snapshot of the path list when the targetSum is achieved
 */
/**TC = O(N)
 * SC = O(1)
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        backtrack(root, targetSum, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(TreeNode root, int targetSum, int currSum, List<Integer> path){
        //base
        if(root == null){
            return;
        }
        
        //logic
        currSum = currSum + root.val;
        path.add(root.val);
        if((root.right == null && root.left == null) && targetSum == currSum){
            result.add(new ArrayList<>(path)); //new ArrayList to store the current snapshot of the path list
        }
        backtrack(root.left, targetSum, currSum, path);
        backtrack(root.right, targetSum, currSum, path);
        
        //backtrack
        path.remove(path.size() -1);
    }
}
