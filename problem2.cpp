// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Start with the left and right children of the root
// Make sure the left and right nodes are equal and then check for left->left & right->right
// After that check for left->right and right->left, to maintain the mirror image property

class Solution {
private:
    bool helper(TreeNode* left, TreeNode* right) {
        // base case:
        if(!left && !right) {
            return true;
        }
        // logic:
        if((!left || !right) || (left->val != right->val)) {
            return false;
        }

        return helper(left->left, right->right) && helper(left->right, right->left);
    }
public:
    bool isSymmetric(TreeNode* root) {
        if(!root) return true;
        return helper(root->left, root->right);
    }
};