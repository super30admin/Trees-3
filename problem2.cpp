/*
Time complexity - O(N)
Space complexity - O(H), H is the height of the recursion stack
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
    bool res = true;
    bool isSymmetric(TreeNode* root) {
        helper(root->left, root->right);
        return res;
    }
    
private:
    void helper(TreeNode* left, TreeNode* right){
        if (!left && !right) return;
        if (!left || !right || left->val != right->val){
            res = false; return;
        }
        helper(left->left, right->right);
        helper(left->right, right->left);
    }
};