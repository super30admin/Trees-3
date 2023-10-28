// similar to pathSum1
// we keep track of the path and the sum 
// once we are going back in the path, we remove the elements from the list

//list is local variable here
//WORKS ON LEETCODE

//TC: O(n) going through all the nodes
//SC: O(h) at a given point in time there are nodes equivalent to the height of the tree


import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
        }

    class Solution {

        List<List<Integer>> result;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            this.result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            targetSum(root, list, 0, targetSum);
            return result;
        }
    
        public void targetSum(TreeNode root, List<Integer> list, int currSum, int target)
        {
            if(root == null) return;
    
            currSum += root.val;
            list.add(root.val);
    
            if(currSum == target && root.left == null && root.right == null)
            {
                List<Integer> listCopy = new ArrayList<>(list);
                result.add(listCopy);
            }
    
            targetSum(root.left, list, currSum, target);
            targetSum(root.right, list, currSum, target);
            list.remove(list.size()-1);
    
        }
    }
}