// Time Complexity : O(N)
// Space Complexity : O(N**2) (only in worst case)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// I have used same list to add the elements to a single list.

// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        traverse(root, sum, new ArrayList());        
        return result;        
    }
    
    public void traverse(TreeNode node, int sum, List<Integer> list) {
        
        if(node == null)
            return;
        sum -= node.val;
        list.add(node.val);
        if(sum  == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList(list));
        }
        traverse(node.left, sum,  list);
        traverse(node.right, sum, list);
        
        list.remove(list.size() - 1);
        
    }
}