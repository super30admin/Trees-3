// Time Complexity : O(N) where N is the number of nodes in the tree
// Space Complexity : O(H) where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/symmetric-tree/
// Submission Link: https://leetcode.com/submissions/detail/538467253/

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        return helper(root -> left, root -> right);
    }
    
    bool helper(TreeNode* left, TreeNode* right){
        if(left == NULL && right == NULL)
            return true;
        
        if(left == NULL || right == NULL || left -> val != right -> val)
            return false;
        
        return helper(left -> left, right -> right) && helper(left -> right, right -> left);
    }
};