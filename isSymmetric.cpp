// Time Complexity : o(n)
// Space Complexity : o(n)
// Where n = number of elements in the list given
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
public:
    bool helper(TreeNode* leftRoot, TreeNode* rightRoot) {
        if(leftRoot == NULL && rightRoot == NULL) {
            return true;
        }
        if(leftRoot!=NULL && rightRoot==NULL || leftRoot==NULL && rightRoot!=NULL) {
            return false;
        }
        if(leftRoot->val != rightRoot->val) {
            return false;
        }
        return helper(leftRoot->right, rightRoot->left) && helper(leftRoot->left, rightRoot->right);    
    }
    bool isSymmetric(TreeNode* root) {
        if(root==NULL) {
            return true;
        }
        return helper(root->left, root->right);
    }
};