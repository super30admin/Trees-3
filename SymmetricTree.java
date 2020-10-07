// Time Complexity : O(n), O(n) to generate inorder traversal, O(n) to find root_elem_index in inorder array, O(n) to check if left half is mirror of right half
// Space Complexity : O(n), O(n) for storing inorder traversal array, O(log n) for stack space
// Did this code successfully run on Leetcode : no, passed only 191/195 test cases, failed for a case where subtree was not a mirror but inorder traversal left and right halves were mirror
// Any problem you faced while coding this : Thinking of what would work for all test cases, what could be the different ways to check symmetry

// Your code here along with comments explaining your approach
// this might be a long approach but my idea was to generate inorder traversal, find root_idx, check if left half elements were a mirror of right half 

class Solution {
    ArrayList<Integer> inorder = new ArrayList<Integer>();
    
    private void inorderTraversal(TreeNode root){
        if(root==null) return;
        
        if(root.left!=null) inorderTraversal(root.left);
        inorder.add(root.val);
        if(root.right!=null) inorderTraversal(root.right);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        
        inorderTraversal(root);
        
        int root_idx = 0;
        for(int i=0; i<inorder.size(); i++){
            if(inorder.get(i)==root.val){
                root_idx = i;
                break;
            } 
        }
        
        int i = root_idx - 1;
        int j = root_idx + 1;
        
        while(i>=0 && j<=inorder.size()-1){
            if(inorder.get(i)==inorder.get(j)){
                i--;
                j++;
            }
            else break;
        }
        
        if(i<0 && j>inorder.size()-1){
            return true;
        }
        return false;
    }
}