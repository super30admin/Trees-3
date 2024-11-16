// Time Complexity : O(n( ))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach - we are using backtracking here to get all the paths. If we reach the
//path then we add it to the result, else recurse left and right 

public class PathSumII{
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        helper(list, 0, root, targetSum);
        return result;
    }

    public void helper(List<Integer> path, int currSum, TreeNode node, int targetSum){
        //base 
        if(node == null) return;

        //logic 
        currSum += node.val;
        path.add(node.val);
        if(node.left == null && node.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(path, currSum, node.left, targetSum);
        helper(path, currSum, node.right, targetSum);
        path.removeLast();
    }
}