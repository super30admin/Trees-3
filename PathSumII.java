// Time Complexity : O(n); visiting all the root nodes till the leaf.
// Space Complexity : O(n) just for recursive call stack. Variables O(1) since storing the result to be returned;
// If you consider the sublist then logically we are using it as temporary array, since after iterating we are removing the nodes so at the end of iteration the sublist will become empty.
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/655391850/)
// Any problem you faced while coding this : No
// My Notes : Iterate it similar to the sum-to-the-leaf node and then remove the node after visiting the right node.
class Solution {
    private List<List<Integer>> result = new ArrayList();
    private List<Integer> subList = new ArrayList();
    private int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preOrder(root, targetSum);
        //System.out.println(result);
        return result;
    }
    
    private void preOrder(TreeNode root, int targetSum){
        // Terminate if the root is encounterd or the sum exceeds 
        if(root == null){
            return;
        }

        // Adding root 
        subList.add(root.val);
        sum+=root.val;
        
        //System.out.println("Root "+root.val+", sum : "+sum + ", "+subList);

        // Check if reached the leaf node
        if(root.left == null && root.right == null){
            // Add to result if the sum is equal to the target sum
            if(sum == targetSum){
                // List<Integer> list_ = subList.clone();
                result.add((List)((ArrayList) subList).clone());
            }
        }
        preOrder(root.left, targetSum);
        preOrder(root.right, targetSum);
        sum-=subList.get(subList.size()-1);
        subList.remove(subList.size()-1);
    }
}