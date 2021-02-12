import java.util.*;
//Problem1
// Time Complexity :O(n)
// Space Complexity : O(depth)

class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        //output list
        List<List<Integer>> output = new ArrayList<>(); 

        //list to store the sum at each node
        List<Integer> path = new ArrayList<>();
        
        sum(root, targetSum, output, path, 0);
        
        return output;
    }
    private void sum(TreeNode root, int target, List<List<Integer>> output, List<Integer> path, int curr){
        //base condition 1
        if(root == null){
            return;
        }

        //sum at each node
        curr = curr + root.val;

        //add the sum to the path list
        path.add(root.val);
        
        //base case 2: when at the leaf
        if(root.left == null && root.right == null){

            //check if the curr sum == target
            if(target == curr){

                //then add the path list to a new array temp list
                //we do this because the path list keep changing at every node
                List<Integer> temp = new ArrayList<>(path);

                //add the temp list to the output
                output.add(temp);
            }
            
        }
        
        //recurssion to the left and then right
        //preorder
        sum(root.left, target, output, path, curr);
        sum(root.right, target, output, path, curr);
        
        //remove the last elemnt from the when we do'nt hit the 2nd base case
        path.remove(path.size() - 1);
    }
}


//Problem1
// Time Complexity :O(n)
// Space Complexity : O(depth)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return symmetric(root.left, root.right);
    }
    private boolean symmetric(TreeNode l, TreeNode r){

        //base case 1: if both the nodes are null
        //It is symmetric
        if(l == null && r == null){
            return true;
        }

        //base case2: if just the left node is null
        //or if just the right node is null
        //or left node is not equal to the right node
        if(l == null || r == null || l.val != r.val){

            //then it is not symmetric
            return false;
        }

        //if it comes at this point
        //then return the result of
        //left of left with right of right
        //and right of left with left of right
        return symmetric(l.left, r.right) && symmetric(l.right, r.left);
    }
}