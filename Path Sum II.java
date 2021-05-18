//Time Complexity : O(N)
//Space Complexity : O(h). h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root==null){
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        //helper function to traverse
        inorder(root,targetSum,0,temp);
        return result;
    }
    private void inorder(TreeNode root, int target,int sum, List<Integer> temp){
        if(root==null){
            return;
        }
        //add the val at each level
        temp.add(root.val);
        //add the nodes value at each level
        int cursum = root.val + sum; 
        //visit the lest side
        inorder(root.left,target,cursum,temp);
        //once the leaf node is found add the current list to main list
        if(root.left==null && root.right==null){
            if(cursum==target){
                //copy the list so far into the result list
                result.add(new ArrayList<>(temp));
            }
        }
        //visit the right side
        inorder(root.right,target,cursum,temp);
        //backtrack : if the target is not matched themn remove the last visited node and change the path
        temp.remove(temp.size()-1);
    }
}