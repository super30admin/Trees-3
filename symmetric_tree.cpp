// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    bool sum_rec(TreeNode* l_root, TreeNode* r_root)
    {
        // One is Null, Other is Not
        if(l_root == NULL ^ r_root == NULL)
            return false;
        
        // Both are NULL
        if(!l_root && !r_root)
            return true;
        
        if(l_root->val != r_root->val)
            return false;
        
        int res;
        
        // 2 nodes are equal
        res = sum_rec(l_root->left, r_root->right);
        
        res &= sum_rec(l_root->right, r_root->left);
            
        return res;
    }
    
    bool isSymmetric(TreeNode* root) {
        
        if(!root->left && !root->right)
            return true;
        
        int res = sum_rec(root->left, root->right);
        
        return res;
    }
};