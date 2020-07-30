//Time Complexity - O(n)
//Space Complexity - O(2h)=O(h)
//Ran successfully on leetcode
//3 point algo -
	/*1.We created a left and right subtree
	2.We traverse through the two trees and check if the corresponding left and right elements respectively are the same
	3.If not, we return false. Else we move further in the recursion*/
	
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
        TreeNode*L=root->left;
        TreeNode*R=root->right;
        return helper(L,R);
    }
    bool helper(TreeNode*L,TreeNode*R)
    {
        if(L==NULL && R==NULL)
            return true;
        if(L==NULL || R==NULL || L->val!=R->val)
            return false;
        return helper(L->left,R->right)&&helper(L->right,R->left);
    }
};