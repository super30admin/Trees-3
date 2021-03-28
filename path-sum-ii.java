// Time Complexity : O(n^2) where n is number of nodes
// Space Complexity : O(n) where n is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //TC : O(n^2) where n is number of nodes
    //SC : O(n) where n is height of tree
    List<List<Integer>> result = new ArrayList<>();//global variable to store final result, list of lists
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return result;//base condition
        
        List<Integer> temp = new ArrayList<>();
        
        calSum(root,targetSum, temp,0);//passing root, targetSum, temp and 0 as currentsum
        
        return result;
    }
    
    private void calSum(TreeNode root, int targetSum, List<Integer> temp, int currSum){
        if(root==null) return ;//base-condition
        
        currSum = currSum+root.val; // adding sum until we reach the leaf node
        temp.add(root.val);//add to temp list even if currSum>targetSum until leaf node
        //if(currSum > targetSum) return ;
        
        //when we reaach leaf node, check if currSum== targetSum
        if(root.left==null && root.right==null){   
            if(currSum==targetSum){
                //creating a new list because java arrays are pass by reference and temp has all leaf values
                //if we don't modify this and add temp, ulitmate result list would be empty
                List<Integer> path = new ArrayList<>(temp);
                result.add(path);//add to result
            }
            temp.remove(temp.size()-1);//remove from temp list even if the sum equals currSum and even if it's not
            return ;
        }
        
        calSum(root.left,targetSum,temp,currSum);
        calSum(root.right,targetSum, temp, currSum);
        
        //this statement is required to remove the previously added pathsum even if it matches result sum
        //for example 5-> 11 -> 4 -> 2 equals 22 but 11 needs to be removed after this, similarly 4 as well
        temp.remove(temp.size()-1);
    }
}
