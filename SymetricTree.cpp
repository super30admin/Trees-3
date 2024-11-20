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
// we can intialize two pinters one to left node and 
// other to the right node of tree 
// now we can iterate the tree in preorder manner such that
// left->left node compare to right-right
// left->right node and right->left
// and compare the each node to the other node

class Solution {
public:
    bool helper(TreeNode* p , TreeNode* q)
    {
        //Now compare if two nodes are same
        //base case
        if(p==NULL && q==NULL)
            return true;
        if(p==NULL || q==NULL)
            return false;
        if(p->val != q->val)
            return false;
        
        return helper(p->left,q->right) && helper(p->right , q->left);
    }
public:
    bool isSymmetric(TreeNode* root) {
        return helper(root->left,root->right);
    }
};
//Time complexity O(N)
//Space complexity O(H)