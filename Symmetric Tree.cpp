//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        
        if(root==NULL){
            return true;
        }
        
        return isSame(root->left,root->right);
    }
    
    bool isSame(TreeNode* left,TreeNode* right){
        
        if(left==NULL && right==NULL){
            return true;
        }
        if(left==NULL || right==NULL){
            return false;
        }
        return left->val==right->val && isSame(left->left,right->right) && isSame(left->right,right->left);
    }
};