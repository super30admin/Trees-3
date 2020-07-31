import java.util.ArrayList;
import java.util.List;

//Approach: 
//1. Local variable currSum is kep to calculate the sum at each node. Once we reach the leaf node, we check with global variable target and if its equal we will add the list to result.
//2. a new copy of list is created and sent at each node such that each node contains a new copy along with previous nodes. This is for returning the path that earned the sum.
//3. We do this operation, recursively and check all the paths, finally adding the ones with target sum to the result.
public class Path_Sum_II {
	List<List<Integer>> result; int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        result = new ArrayList<>();
        if(root == null)
            return result;
        
        helper(root, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> temp)
    {
        if(root == null)
            return;
        currSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null)  
        {
            if(currSum == target)
            {
                result.add(new ArrayList<>(temp));
            }
        }        
        helper(root.left, currSum, new ArrayList<>(temp));
        helper(root.right, currSum, new ArrayList<>(temp));
    }
}

//Time Complexity : O(n ^ 2)  where n is the number of nodes
//Space Complexity : O(n ^ 2)  since we might be creating these many number of arrays at each node. 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :