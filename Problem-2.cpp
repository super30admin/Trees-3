class Solution {
public:
  //O(n)+O(h)
    bool go(TreeNode *t1, TreeNode *t2){
        if(!t1 && !t2) return 1;
        if(!t1 || !t2) return 0;
        return (t1->val== t2->val && go(t1->left,t2->right ) && go(t1->right, t2->left));
    }
    bool isSymmetric(TreeNode* root) {
        if(!root) return true;
        TreeNode *t1=NULL, *t2=NULL;
        if(root->left!=NULL) t1= root->left;
        if(root->right!=NULL) t2= root->right;
        return go(t1,t2);
    }
};
