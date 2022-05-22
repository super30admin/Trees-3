//TC = O(N)
//SC = O(H)
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root==NULL) return true;
        return helper(root->left,root->right);
    }
    
    bool helper(TreeNode *l, TreeNode *r){
            //base
            if(l==NULL && r==NULL) return true;
            if(l==NULL || r==NULL) return false;
            if(l->val != r->val) return false;
            //logic
            return (helper(l->left,r->right) && helper(l->right,r->left));
        }  
};
