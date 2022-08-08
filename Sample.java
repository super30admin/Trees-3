//path sum -2
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yeah referred class to clear doubts


// Your code here along with comments explaining your approach : Here we need to find the paths that are equal to the target
//sum in the given tree. Here the main to be taken care to list are modified by reference. So everytime we add the path to
// ythe result list we make new list(we are making deep copy of it).

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result= new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        helper(root,0,path,targetSum);
        return result;

    }

    private void helper(TreeNode root,int currSum,List<Integer> path,int target){
        //base
        if(root==null) return;
        currSum+= root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum== target){
                System.out.println(path);
                result.add(new ArrayList(path));
            }
        }
        helper(root.left, currSum,path,target);
        helper(root.right, currSum,path,target);
        //backtrack
        path.remove(path.size()-1);
    }
}
//Symmetric tree
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach:Here we need to check whether two trees symmetric.so to achieve
// that we treat left if root as left tree and right of root as right tree. Further we check whether right of left tree is
//similar as left of right tree and vice versa. If they are equal we retun true else false


class Solution {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;

        return helper(root.left,root.right);


    }
    private boolean helper(TreeNode left, TreeNode right){
        if((left == null) && (right != null)){
            return false;
        }
        if((left != null) && (right == null)){
            return false;
        }


        if(left == null){
            return true;
        }

        if(left.val != right.val) return false;
        return helper(left.left,right.right) &&  helper(left.right,right.left);


    }
}