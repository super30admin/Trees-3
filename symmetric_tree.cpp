//Time complexity : O(n)
//Space complexity : O(h)

//Approach :
            //From 3rd level onwards,
            //Check left->left with right->right and left->right with right->left
            //If mismatch found at any point, return false

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root == nullptr)
            return true;
        
        return sym(root->left, root->right);
    }
    
    bool sym(TreeNode* left, TreeNode* right)
    {
        if(left == nullptr && right == nullptr)
            return true;
        
        if(left == nullptr || right == nullptr || left->val != right->val)
            return false;
        
        return sym(left->left, right->right) && sym(left->right, right->left);
    }
};