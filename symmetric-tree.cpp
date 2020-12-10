//Time complexity - O(n) n - number of nodes
//Space complexity - O(n)

class Solution {
public:
    bool isMirror(TreeNode* l, TreeNode* r){
        if(l==NULL && r==NULL){
            return 1;
        }
        else if(l==NULL || r==NULL) return 0;
        return l->val == r->val && isMirror(l->left,r->right) && isMirror(l->right,r->left);
    }
    bool isSymmetric(TreeNode* root) {
        if(root==NULL) return 1;
        return isMirror(root->left, root->right);
    }
};