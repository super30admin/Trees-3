// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool sym(TreeNode *a,TreeNode *b)
    {
        if(a==NULL && b==NULL)
            return true;
        
        if(a!=NULL && b!=NULL && a->val==b->val)
            return sym(a->left,b->right)&&sym(a->right,b->left);
        
        return false;
    }
    bool isSymmetric(TreeNode* root) {
        if(root==NULL)
            return true;
        
       return sym(root,root);
    }
};