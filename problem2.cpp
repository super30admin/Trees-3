// Time Complexity : O(n)
// Space Complexity : O(h) where h = height of tre (stack space for recurrsion)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root==NULL) 
            return true;
        return symTest(root->left,root->right);
    }

     bool symTest(TreeNode* right , TreeNode* left){        //right = right sub tree, left = left sub tree
        
        if(right == NULL && left == NULL) // terminating condition
            return true; 
        
        else if(right == NULL || left == NULL) // unbalanced sub trees
            return false; 
        
        else if(right->val!=left->val) 
            return false;
        
        return symTest(right->left,left->right) && symTest(right->right,left->left); 
        
        //comparing left subtree's left child with right subtree's right child --AND-- comparing left subtree's right child with right subtree's left child
    }
};