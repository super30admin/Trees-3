//Time Complexity - O(N)
//Space Complexity - O(h)
class Solution {
public:
    bool helper(TreeNode* root1, TreeNode* root2){
        if(!root1 && !root2)
            return true;
        if(!root1 || !root2||root1->val!=root2->val)
            return false;
        return helper(root1->left,root2->right)&&helper(root1->right,root2->left);
    }    
    bool isSymmetric(TreeNode* root) {
        return helper(root,root);
    }
};