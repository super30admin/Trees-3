TC:O(N)
SC:O(H)

// A tree to be symmetric left side should be mirror image of right
// left->left should be equal to the right->right
// And left->right should be equal to right->left

class Solution {
public:
    bool isSymmetric(TreeNode* root) {

        return func(root->left,root->right);  
    }


    bool func(TreeNode* left, TreeNode* right)
    {
    
        if(left==nullptr && right==nullptr)
         return true;

        if(left==nullptr || right==nullptr)
         return false;
         
         if(left->val != right->val)
         return false;

               bool case1=func(left->left,right->right);
               bool case2=func(left->right,right->left);
               return case1 && case2;
       
    }

};