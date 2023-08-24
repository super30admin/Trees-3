// Time Complexity : O(n*h)
// Space Complexity : O(n*h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using 
class Solution {
   
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result=new ArrayList<>();
        helper(root, 0,targetSum,new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum, ArrayList<Integer> path){
        //base condition
        if(root==null)
            return;
        //logic
        currSum+=root.val;

        //new list
        //ArrayList<Integer> newli = new ArrayList<>(path);
        //newli.add(root.val);
        //if(root.left==null && root.right==null){
        //    if(currSum==targetSum)
        //        result.add(newli); 
        //}

        //recursion
        //helper(root.left,currSum,targetSum,newli);
        //helper(root.right,currSum,targetSum,newli);


        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum==targetSum)
                result.add(path); 
        }
        //recursion
        helper(root.left,currSum,targetSum,new ArrayList<>(path));
        helper(root.right,currSum,targetSum,new ArrayList<>(path));
        
    }

}


// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//using recusion with backtracking
class Solution {
   
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result=new ArrayList<>();
        backtrack(root, 0,targetSum,new ArrayList<>());
        return result;
    }

    private void backtrack(TreeNode root, int currSum, int targetSum, ArrayList<Integer> path){
        //base condition
        if(root==null)
            return;
        //logic
        currSum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum==targetSum)
                result.add(new ArrayList<>(path)); //O(1) DEEPCOPY TIME
        }
        //recursion
        backtrack(root.left,currSum,targetSum,path);
        backtrack(root.right,currSum,targetSum,path);
        //backtrack
        path.remove(path.size()-1);
    }

}