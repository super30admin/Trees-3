//time complexity: O(n)
//space complexity:O(n)
//approach: recursion
//solved on leetcode? yes
//problem faced? no

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
        if(root==NULL)
            return true;
        return helper(root->left, root->right);
    }
    bool helper(TreeNode* left, TreeNode* right)
    {
        if(left==NULL || right==NULL)
            return left==right;
        if(left->val!=right->val)
            return false;
        return helper(left->right, right->left)&&helper(left->left, right->right);
    }
};