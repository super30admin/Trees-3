// ## Problem2 (https://leetcode.com/problems/symmetric-tree/)
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
// Input: root = [1,2,2,3,4,4,3]
// Output: true



// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
Solution:
class Solution {
    //maintaining a global variable
    boolean isSymetric;
    public boolean isSymmetric(TreeNode root) {
        //best case condition check
        if(root ==null){
            return true;
        }
        isSymetric = true;
        dfs(root.left,root.right);
        return isSymetric;
    }
    private void dfs(TreeNode left, TreeNode right){
        //base case condition check and processing
        if(left==null && right==null){
            return;
        }
        if(left == null || right==null){
            isSymetric=false;
            return;
        }
        if(left.val != right.val){
            isSymetric=false;
            return;
        }
        //Recursive calls
        dfs(left.left,right.right);
        dfs(left.right, right.left);
    }
}

//Code Optimization by removing global variable
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root ==null){
            return true;
        }
        return dfs(root.left,root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left == null || right==null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        boolean case1 = dfs(left.left,right.right);
         boolean case2 = dfs(left.right, right.left);

         return case1 && case2;
    }
}

//Further code optimization
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root ==null){
            return true;
        }
        return dfs(root.left,root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left == null || right==null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

         return dfs(left.left,right.right) && dfs(left.right, right.left);
    }
}

//Using BFS traversal
// Time Complexity :O(n)
// Space Complexity :O(n)
// Approach : In this we are doing a level order traversal BFS and we are going and adding 
// q.add(left.left);
// q.add(right.right);
// q.add(left.right);
// q.add(right.left);
// and then as the both left and right should be same we are checking if same then fine else we are returning false and breaking a loop
class Solution {
    //Global variable 
    boolean symmetric;
    public boolean isSymmetric(TreeNode root) {
        //base case condition check
        if(root==null){
            return true;
        }
        //initializing a global variable to true;
        symmetric=true;
        //calling a BFS traversal
        bfs(root);
        return symmetric;
    }
    private void bfs(TreeNode root){
        //Initializing a queue
        Queue<TreeNode> q = new LinkedList<>();
        //adding root's left and right and they can be null 
        q.add(root.left);
        q.add(root.right);
        //while loop to traverse a queue
        while(!q.isEmpty()){
            TreeNode left=q.poll();
            TreeNode right=q.poll();
            //If both are null then we will continue
            if(left==null && right==null){
                continue;
            }
            //If both are not null as we have checked in above condition and one of them is null then that is the breach 
            if(left==null || right ==null){
                symmetric=false;
                break;
            }
            //If both's value is not same then thaat is the breach
            if(left.val!=right.val){
                symmetric=false;
                break;
            }
            //We are adding elemment in a queue
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
    }
}

// Code optimization

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left=q.poll();
            TreeNode right=q.poll();
            if(left==null && right==null){
                continue;
            }
            if(left==null || right ==null){
                return false;
            }
            if(left.val!=right.val){
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        
        }
        return true;
    }
}
    