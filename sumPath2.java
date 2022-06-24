//Time Complexity: O(n)
//Space Complexity: O(h), h is the height of the tree
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

//backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        //null
        if(root == null) return result;
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
        
    }
    private void helper(TreeNode root, int currSum, List<Integer> path, int target){
        //base
        if(root == null) return;
        //logic
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        //recursion
        //left
        helper(root.left, currSum, path, target);
        //st.pop()
        helper(root.right, currSum, path, target);
        //backtrack
        path.remove(path.size()-1);
    }
}

/*2
//copying list everytime as we don't want the whole path we just need the path to the target.
// time complexity in worst case goes to n^2  and dominating space in worst case is n^2 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        //null
        if(root == null) return result;
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
        
    }
    private void helper(TreeNode root, int currSum, List<Integer> path, int target){
        //base
        if(root == null) return;
        //logic
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(path); // we can remove it as we don't need to push a new array we already are getting a new array.
            }
        }
        //left
        helper(root.left, currSum, new ArrayList<>(path), target);
        //st.pop()
        
        helper(root.right, currSum, new ArrayList<>(path), target);
    }
}
*/

/*1
//wil return both array and we are not removing the values
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        //null
        if(root == null) return result;
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
        
    }
    private void helper(TreeNode root, int currSum, List<Integer> path, int target){
        //base
        if(root == null) return;
        //logic
        currSum += root.val;
        path.add(root.val);
        //left
        helper(root.left, currSum, path, target);
        //st.pop()
        if(root.left == null && root.right == null){ // we can also check it after base case
            if(currSum == target){
                result.add(path);
            }
        }
        helper(root.right, currSum, path, target);
    }
}
*/