// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        return root == NULL || isSymmetricHelp(root->left, root->right);
    }
    bool isSymmetricHelp(TreeNode *left, TreeNode *right)
    {
        if(left == NULL || right == NULL)
        {
            return left == right;
        }
        if(left->val != right->val)
        {
            return false;
        }
        
        return isSymmetricHelp(left->left , right->right)
        && isSymmetricHelp(left->right, right->left);
        

    }
};
