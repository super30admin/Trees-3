// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// If we are copying the paths everytime when we pop the element from the recursive stack that is O(N2)
// so we backtrack - meaning we will undo the action everytime we go back back after the recursion- so pop the last element from the path
//we dont have to create a new arraylist everytime when we do left or right recursive call instead we can remove everytime we go back.



class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        target=targetSum;
        helper(root,0,new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currsum, List<Integer> path){
        if(root==null) return;
        currsum+=root.val;
        path.add(root.val);
        
        helper(root.left,currsum,path);
        if(root.left==null && root.right==null){
            if(currsum==target){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.right,currsum,path);
        path.remove(path.size()-1);
    }
}