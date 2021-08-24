// Time Complexity :O(n)
// Space Complexity :O(height of tree)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// recursively traverse the tree 
// check if the left child of  left parent == right child of the right parent
// check if the right child of  left parent == left child of the right parent

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
        if(root== nullptr){
            return true;
        }
        
        return helper(root->left,root->right);
        
    }
    bool helper(TreeNode* left,TreeNode* right){
        // base
        if(left== nullptr && right == nullptr){
            return true;
        }
        else if(left== nullptr || right ==nullptr){
            return false;
        }
        else if(left->val != right->val){
            return false;
        }
        return helper(left->left,right->right) && helper(left->right,right->left);
        
    }
   
};