// Time Complexity : O(n)
// Space Complexity : O(2h) [for stack + for path arraylist]
//which can have max of O(h) elements at a given point 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

import java.util.ArrayList;
import java.util.List;

//Path sum II
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){

        if(root == null) return; //base case
        
        currSum=currSum+root.val; //currSum should be local variable , as it changes at every stage.
        path.add(root.val);


        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                //make new list to add to result, we dont want a reference in result which we are
                //processing.
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        path.remove(path.size()-1); //remove elemnt form path list after left and right subtree are processed

    }
}