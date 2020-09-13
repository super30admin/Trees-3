    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/path-sum-ii/
    Time Complexity for operators : o(n) .. number of  elements in the tree
    Extra Space Complexity for operators : o(depth of a tree) ... depth of a tree innerList only have element equal to depth of tree.
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach :

        # Optimized approach same like basic approach: Recursion.
                              
            # 1st one - Recursive Approach
                    A. create function and pass root, target, current sum, and inner list which will store the data.
                    B. if left and right is null that means we reached till end then check whether sum == target if not then return
                    C. else add last element into new array and then add new array to the final list. last element is not needed in innerList for future use.
                    D. once done with this call add elemetn to the inner list and then do recusive call to left and right with appropriate values.
                    E. At the end remove last element as we processed that element completely.
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

   class pathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        recursion(root,sum,0,new ArrayList<>());
        return output;
    }
    
    List<List<Integer>> output = new ArrayList<>();
    
    private void recursion(TreeNode root, int target,int currentSum, List<Integer> innerList){
        if(root==null)
            return;
        
        if(root.left==null && root.right == null){
            
            if(currentSum + root.val == target){
                List<Integer> temp = new ArrayList(innerList);
                temp.add(root.val);
                
                output.add(temp);
            }
            return;
        }
        
        innerList.add(root.val);
        
        recursion(root.left,target,currentSum+root.val,innerList);
        recursion(root.right,target,currentSum+root.val,innerList);
        
        innerList.remove(innerList.size()-1);
    }
}
