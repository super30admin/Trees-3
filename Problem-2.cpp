// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// All the nodes to the left of left should be same as the right of right.
// Similarly, all the nodes to the right of left is same as the nodes to the left of right.
// Traverse in these directions, if the values are not matching or reached NULL then return false else true.

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
        bool helper(TreeNode* left, TreeNode* right){
            if(left == NULL && right == NULL) return true;
            if(left == NULL || right == NULL || left->val != right->val) return false;
    
            return helper(left->left, right->right) && helper(left->right, right->left);
    
        }
        bool isSymmetric(TreeNode* root) {
            if(root == NULL) return true;
            return helper(root->left, root->right);
        }
    };