
//
// ## Problem2 (https://leetcode.com/problems/symmetric-tree/)

//TC- O(n) as traversing all n nodes
//SC- O(h) where h is height of tree
//Idea -to recrusively traverse and check for (left->left && right->right ) && (left->right && right->left)

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
        //check for single node 
        if(root==NULL || (root->left ==NULL && root->right ==NULL)){
            return true;
        }
        
        return helper(root->left, root->right);
    }
    
    bool helper(TreeNode* leftnode, TreeNode* rightnode){
        if (leftnode ==NULL && rightnode ==NULL){
            return true;
        }
        if (leftnode ==NULL || rightnode ==NULL ||  leftnode->val != rightnode->val){
            return false;
        }
        return( helper(leftnode->left,rightnode->right) && helper(leftnode->right, rightnode->left) );
        
    }
};