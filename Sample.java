//Prob-1
// Time Complexity : O(n) where n is the number of elements in the tree
// Space Complexity : O(h) stack space
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Backtrack solution 
class Solution {
    List<List<Integer>> result;
    List<Integer> temp;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        result = new ArrayList<>();
         temp = new ArrayList<>();
        helper(root, sum, 0, temp);
        return result;
    }
    
    private void helper(TreeNode root, int sum, int curSum, List<Integer> temp){
        //base
        if(root == null) return;
        //logic
        curSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(curSum == sum){
                result.add(new ArrayList<>(temp));
            }
        }
         helper(root.left, sum, curSum, temp);
         helper(root.right, sum, curSum, temp);
        temp.remove(temp.size()-1); // undo the last decision
        
    }
}
// recursive solution
// Time Complexity : O(n^2) where n is the number of elements in the temp array to copy from former stack frame. 
// Space Complexity : O(h*n) stack space + n is the num of elmnts in the temp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, 0, temp); 
        return result;
    }
    
    private void helper(TreeNode root, int sum, int curSum, List<Integer> temp){
        //base
        if(root == null) return;
        //logic
        curSum+= root.val; // adding the value of the current root
        temp.add(root.val); 
        if(root.left == null && root.right == null){
            if(curSum == sum){
                result.add(temp); // adding the path to the return list
            }
        }
         helper(root.left, sum, curSum, new ArrayList<>(temp)); // Making a new copy of the arrayList with every recursive step
         helper(root.right, sum, curSum, new ArrayList<>(temp));
        
    }
}
//Prob-2
// Time Complexity : O(n) where n is the numbr of elmnts in the tree
// Space Complexity : O(h) stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// recursive solution
class Solution {
    private boolean helper(TreeNode left, TreeNode right){
        //base
        if(left == null || right == null) return left == right; // reaching a leaf node or when one is present but the other one is not
        //logic
        if(left.val != right.val) return false;
        //recurse
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return helper(root.left, root.right);
    }
}
//iterative solution TC = O(n) because adding each and every tree node once, SC = O(h) = stack space
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> s = new Stack();
        s.push(root.right); 
        s.push(root.left);
        
        while(!s.isEmpty()){
            
            TreeNode left = s.pop(); 
            TreeNode right = s.pop();
            
            if(left == null && right == null) continue; // leaf node
            
            if( left == null || right == null || left.val != right.val){
                return false;
            }
            
                s.push(left.left);
                s.push(right.right);
                s.push(left.right);
                s.push(right.left);
            
        }
        return true;
        
    }
}
