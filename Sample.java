// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1.path-sum-ii
//Time complexity -> O(n)
//Space Complexity -> O(h)
//In time complexity -> if we use deep copy to copy elements of arrays at each level into a new array then the time complexity will be O(n*h) where n-> elements of array of nodes at each level and doing the operation at each level 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        int currSum = 0;
         List<Integer> li = new ArrayList();
        helper(root,currSum,targetSum,li);
        return result;
        
    }

    private void helper(TreeNode root,int currSum,int targetSum,List<Integer> path){
        //base
        if(root == null) return;

        //action
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList(path));
            }
        }
        //recurse
        helper(root.left,currSum,targetSum,path);
        helper(root.right,currSum,targetSum,path);

        //backTrack
        path.remove(path.size() -1);

        
    }
}

class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        int currSum = 0;
        path = new ArrayList();
        helper(root,currSum,targetSum);
        return result;
        
    }

    private void helper(TreeNode root,int currSum,int targetSum){
        //base
        if(root == null) return;

        //action
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList(path));
            }
        }
        //recurse
        helper(root.left,currSum,targetSum);
        helper(root.right,currSum,targetSum);

        //backTrack
        path.remove(path.size() -1);

        
    }
}
class Solution {
    //Using global path list
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        int currSum = 0;
        path = new ArrayList();
        helper(root,currSum,targetSum);
        return result;
        
    }

    private void helper(TreeNode root,int currSum,int targetSum){
        //base
        if(root == null) return;

        //action
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList(path));
            }
        }
        //recurse
        helper(root.left,currSum,targetSum);
        helper(root.right,currSum,targetSum);

        //backTrack
        path.remove(path.size() -1);

        
    }
}
class Solution {
    //Using Path list as a function variable but it will be always same as it is pass by reference
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        int currSum = 0;
         List<Integer> li = new ArrayList();
        helper(root,currSum,targetSum,li);
        return result;
        
    }

    private void helper(TreeNode root,int currSum,int targetSum,List<Integer> path){
        //base
        if(root == null) return;

        //action
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList(path));
            }
        }
        //recurse
        helper(root.left,currSum,targetSum,path);
        helper(root.right,currSum,targetSum,path);

        //backTrack
        path.remove(path.size() -1);

        
    }
}

class Solution {
    //Using Path list as a function variable but it will be always same as it is pass by reference
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        int currSum = 0;
         List<Integer> li = new ArrayList();
        helper(root,currSum,targetSum,li);
        return result;
        
    }

    private void helper(TreeNode root,int currSum,int targetSum,List<Integer> path){
        //base
        if(root == null) return;

        //action
        currSum = currSum + root.val;
        List<Integer> li = new ArrayList(path); //Creating a deep copy
        li.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(li);
            }
        }
        //recurse
        helper(root.left,currSum,targetSum,li);
        helper(root.right,currSum,targetSum,li);

        
    }
}

//2nd Symmetric Tree
//Using BFS
//Time Complexity -> O(n)
//Space Complexity -> O(n)
class Solution {
    //Using DFS using void recursion
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        flag = true;
        if(root == null) return true;
        dfs(root.left,root.right);
        return flag;

    }

    private void dfs(TreeNode left,TreeNode right){
        //base case
        if(left == null && right == null) return;
        //logic
        if(left == null || right == null || left.val!=right.val){
            flag = false;
            return;
        }
        dfs(left.left,right.right);
        dfs(left.right,right.left);
    }
}
class Solution {
    //Using DFS using boolean  recursion
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
        

    }

    private boolean dfs(TreeNode left,TreeNode right){
        //base case
        if(left == null && right == null) return true;
        //logic
        if(left == null || right == null || left.val!=right.val){
            return false;
        }
        boolean left_val = dfs(left.left,right.right); //Call dfs for left left side and right right side
        boolean right_val = dfs(left.right,right.left); //call dfs for left right side and right left side

        return left_val && right_val; //check if both are symmetric then return true else false

    }
}

class Solution {
    //Using DFS using boolean  recursion
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
        

    }

    private boolean dfs(TreeNode left,TreeNode right){
        //base case
        if(left == null && right == null) return true;
        //logic
        if(left == null || right == null || left.val!=right.val){
            return false;
        }
        boolean left_val = dfs(left.left,right.right); //Call dfs for left left side and right right side
        if(left_val == false) return false;
        boolean right_val = dfs(left.right,right.left); //call dfs for left right side and right left side

        return right_val; //check if both are symmetric then return true else false

    }
}

class Solution {
    //Using DFS using boolean  recursion
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
        

    }

    private boolean dfs(TreeNode left,TreeNode right){
        //base case
        if(left == null && right == null) return true;
        //logic
        if(left == null || right == null || left.val!=right.val){
            return false;
        }
        if(dfs(left.left,right.right)==false) return false; //if this condition retuurns false then just return false, no need to call left's right side and righr's left side

        return dfs(left.right,right.left); 
    }
}
