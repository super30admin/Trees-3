

101. Symmetric Tree


Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


TC O(n)
SC O(n)

class Solution {
public:

    bool isSame(TreeNode* t1, TreeNode* t2){
        if(!t1 && !t2){return true;}
        if(t1 && !t2){return false;}
        if(t2 && !t1){return false;}
        if(t1->val==t2->val){return isSame(t1->left,t2->right) && isSame(t1->right,t2->left);}
        return false;
    }

    bool isSymmetric(TreeNode* root) {
    return isSame(root->left,root->right);            
    }
};


