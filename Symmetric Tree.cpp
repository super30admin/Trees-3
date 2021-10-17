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
    bool helper(TreeNode* h1, TreeNode* h2){
        if(!h1 && !h2){
            return true;
        }
        
        if(!h1 || !h2){
            return false;
        }
        
        if(h1->val != h2->val){
            return false;
        }
        
        return helper(h1->left, h2->right) && helper(h1->right, h2->left);
    }
    
    bool isSymmetric(TreeNode* root) {
        return helper(root, root);
    }
    
    
    
};


// Time Complexity = o(n)
// Space Complexity = o(1)
