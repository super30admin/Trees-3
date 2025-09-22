//Time Complexity: O(N)+O(H), where N is number of nodes in the tree as we are traversing all nodes once and O(H) for copying the path list to a new list when we find a valid path.If we consider that O(H) happens at constant number of nodes, then overall time complexity is O(N).
//Space Complexity: O(H)+O(H), O(H) for the recursion stack and O(H) for the path list where H is height of the tree.Hence overall space complexity is O(H).
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * The currSum variable is used to keep track of the sum of the current path from the root to the current node and it is defined in local scope since it has to revert to the previous step when the recursion goes back to the parent node.
 * The path list is used to keep track of the nodes covered from root until the current node. Further, it is not a primitive datatype, hence when it is passed to the helper function, its reference is passed and any changes made to it in the helper function will be reflected in the original list. Hence, we need to remove the last element added to the path list when we go back to the parent node in the recursion.
 * The result list is used to store all the valid paths from root to leaf nodes that sum up to the target value and finally the result list is returned.Further whenever the path list is added to the result list, a new list is created using the path list to avoid reference issues  (at the end after backtracking the path list will be empty and adding this to result gives incorrect result).
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;
class pathSum_ii {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            List<Integer> path= new ArrayList<>();
            int currSum=0;
            helper(root,currSum,targetSum,path);
        
            return result;
        
    }
    private void helper(TreeNode root,int currSum,int targetSum,List<Integer> path)
    {
        if (root==null) return;

        currSum+=root.val;
        path.add(root.val);

        if(root.left==null && root.right==null)
        {
            if(currSum==targetSum)
            {
                List<Integer> list=new ArrayList<>(path);
                result.add(list);
            }
        }

        helper(root.left,currSum,targetSum,path);
        helper(root.right,currSum,targetSum,path);

        path.remove(path.size()-1);


    }
}