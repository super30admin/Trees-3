// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//In this approach we maitain a currsum and path which are local variables because we want to the override the values at each node.
//If we find it is a leaf node and the sum so far is equal to the target then we add that path to the result list.
//We recurse left and right nodes. But we remove the last node of the action taken to prevent creating new lists at every node. 
//We also need to create deep copies for each result path otherwise we will end up removing all the nodes because of the same pointer.
class Solution1 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root,0,new ArrayList<>(), targetSum);
        return result;
    }
    private void helper (TreeNode root, int currSum, List<Integer> path, int targetSum){
        //base
        if(root == null) return;

        //logic
        //actions
        currSum += root.val;
        path.add(root.val);
        if(root.left== null && root.right == null){
            if(currSum == targetSum){
                System.out.println(path);
                result.add(new ArrayList<>(path));
            }
        }
        //recurse
        helper(root.left,currSum,path,targetSum);
        helper(root.right,currSum,path,targetSum);

        //backtrack
        path.remove(path.size()-1);
    }
}


// Time Complexity : O(n^2)
// Space Complexity : O(n^2) worst case if h is n
//Brute force recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root,0,new ArrayList<>(), targetSum);
        return result;
    }
    private void helper (TreeNode root, int currSum, List<Integer> path, int targetSum){
        //base
        if(root == null) return;
        List<Integer> li = new ArrayList<>(path);
        currSum += root.val;
        li.add(root.val);
        if(root.left== null && root.right == null){
            if(currSum == targetSum){
                System.out.println(path);
                result.add(li);
            }
        }
        helper(root.left,currSum,li,targetSum);
        helper(root.right,currSum,li,targetSum);
    }
}