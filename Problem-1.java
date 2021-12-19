// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    class Trio {
        TreeNode root;
        int currSum;
        List<Integer> currList;
        
        Trio(TreeNode root, int currSum, List<Integer> currList){
            this.root = root;
            this.currSum = currSum;
            this.currList = currList;
        }
        public TreeNode getNode() {
            return this.root;
        }
        public int getCurrSum() {
            return this.currSum;
        }
        public List<Integer> getCurrList() {
            return this.currList;
        }
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        helper(root, targetSum, 0, new ArrayList<Integer>());
        
//         List<List<Integer>> result = new ArrayList<>();
//         Stack<Trio> s = new Stack<>();
//         int currSum = 0;
//         List<Integer> currList = new ArrayList<>();
        
//         Trio ob = new Trio(root,currSum,currList);
//         s.push(ob);
//         while(root != null || !s.isEmpty()) {
            
//             ob = s.pop();
            
//             currSum = ob.getCurrSum();
//             root = ob.getNode();
//             currList = ob.getCurrList();
//             if(root == null) {
//                 continue;
//             }
            
//             currSum+=root.val;
//             currList.add(root.val);
            
//             if(currSum == targetSum && root.left == null && root.right==null) {
//                 result.add(new ArrayList(currList));
//             }
            
//             Trio left = new Trio(root.left,currSum,new ArrayList(currList));
//             Trio right = new Trio(root.right,currSum,new ArrayList(currList));
            
//             s.push(left);
//             s.push(right);
            
//         }
        
        
        return result;
    }
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> currList) {
        
        //Base conditions
        if(root == null) {
            return;
        }
        
        currSum += root.val;
        currList.add(root.val);
        
        if(currSum == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList(currList));
            return;
        }
        
        helper(root.left,targetSum,currSum, new ArrayList(currList));
        helper(root.right,targetSum,currSum, new ArrayList(currList));
        //currList.remove(currList.size()-1);
    }
}