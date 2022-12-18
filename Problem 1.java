// Time Complexity : O(n^2), for each leave we are copying h (height of the tree) elements , which could be n in the worst case
// Space Complexity : O(n) in worst case the tree is skewed and n is the max height of the tree and recursive space is going to use it
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
we will calculate the same at each node and keep adding nodes values to the path, once we find a leaf node and if the current sum is equal to the target sum, we will create a new list and add it to result

 */ 
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return result;
        }
        helper(root,0,new LinkedList<Integer>(), targetSum);
        return result;        
    }

    private void  helper(TreeNode root,int currentSum1,LinkedList<Integer> list, int targetSum){
        //logic 
        //Action
        int currentSum =currentSum1 + root.val;
        list.add(root.val);

        // if its leaf node
        if(root.left == null && root.right == null){
            if(currentSum == targetSum){
                result.add(new ArrayList(list)); // O(h)
            }
        }
        //recurse
        //go left

        if(root.left!=null){

            helper(root.left,currentSum,list,targetSum);
            //backtrack
            list.removeLast();
        }

        if(root.right!=null){
           helper(root.right,currentSum,list,targetSum);
            //backtrack
            list.removeLast();
        }
    }
}