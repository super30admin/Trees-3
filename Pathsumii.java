// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach]
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfsRec(root, targetSum, result, new ArrayList<Integer>());  
        return result;
    }
    
    public void dfsRec(TreeNode curr,int targetSum, List<List<Integer>> result,
                      List<Integer> internalList){
        if(curr == null){
            return;
        }
        internalList.add(curr.val);
        //if we find sum, add that into list
        if(curr.val == targetSum && curr.left == null && curr.right == null){
            result.add(internalList);
        }
        
        //left subtree and check if node has target-val number
        dfsRec(curr.left, targetSum - curr.val,result, new ArrayList<Integer>(internalList));
        //right subtree and check if node has target-val number
        dfsRec(curr.right, targetSum - curr.val, result,  new ArrayList<Integer>(internalList));
    }
}