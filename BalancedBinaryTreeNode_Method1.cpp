// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning
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
    bool isBalanced(TreeNode* root) {
        
        if (root == NULL)
            return true;
        
        if (isBalanced(root->left) && isBalanced(root->right)){
            if (abs(height(root->left)- height(root->right))<=1)
                return true;
        
        }
        return false;
    }
    int height(TreeNode* root){
        if (root == NULL)
            return -1;
        
        return max(height(root->left), height(root->right)) +1;
    }
};