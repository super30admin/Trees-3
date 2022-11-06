/*
Time Complexity: O(n) (n-all elements in a tree)
Space Complexity: O(h)(h-height of the tree)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
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
       stack<pair<TreeNode*,TreeNode*>> stck;
        stck.push(pair(root->left,root->right));
        while(!stck.empty()){
            pair p = stck.top();
            stck.pop();
            TreeNode* l = p.first;
            TreeNode* r = p.second;
            
            if(l == NULL && r == NULL){
                continue;
            }
            if(l==NULL || r==NULL || l->val != r->val) {
                return false;
            }
            stck.push(pair(l->right,r->left));
            stck.push(pair(l->left,r->right));
        }
        return true;
    }
    
};