// Time Complexity :O(n)
// Space Complexity :O(n) -recursive stack
// Did this code successfully run on Leetcode :yes

class Solution {
public:
    bool helper(TreeNode* root,TreeNode *root1)
    {
        if(root==nullptr && root1==nullptr) 
        {
            return true;
        }
        if(root==nullptr || root1==nullptr)
        {
            return false;
        }
        return (root->val==root1->val) && helper(root->right,root1->left) && helper(root->left,root1->right);
    }
    
    bool isSymmetric(TreeNode* root) {
        return helper(root,root);
    }
};
