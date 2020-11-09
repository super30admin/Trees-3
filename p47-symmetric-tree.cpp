// Time complexity is O(n) - n is the number of nodes
// Space complexity is O(h) - recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    bool helper(TreeNode* left, TreeNode* right) {
        //base
        if(left == nullptr && right == nullptr) return true;
        
        //logic
        if(left == nullptr || right == nullptr || left->val != right->val) return false;
        return helper(left->left, right->right) && helper(left->right, right->left);
    }
    bool isSymmetric(TreeNode* root) {
        if(root == nullptr) return true;
        return helper(root->left, root->right);
    }
};
