// Time Complexity : 
//    Worst case - O(n) 
// Space Complexity : O(h)
//   Where h is height of tree. 
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english

/* DFS Approach :- 
 * Call recursive method by passing (left->left, right->right) && (left->right, right->left).
 * If the node values don't match return false, else tree is symmetric.
 */

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
        if (root == nullptr)
            return true;
        return helper(root->left, root->right);
    }
    
    bool helper(TreeNode* left, TreeNode* right)
    {
        if (left == nullptr && right == nullptr)
            return true;
        
        if (left == nullptr || right == nullptr 
           || left->val != right->val)
        {
            return false;
        }
        
        return helper(left->left, right->right) && helper(left->right, right->left);
    }
};