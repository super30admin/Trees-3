// Time Complexity : O(n)
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
   	int height(TreeNode * root){
        if(root == NULL)
            return 0 ;
        
        int left_H = height(root->left); //Finding left  subtree height
        int right_H = height(root->right); //Finding right subtree height
        
        //1.It will return -1 if left subtree is not balanced
        //2.It will return -1 if right subtree is not balanced
        //3.If above both condition fails, then is will check the difference in the height of             current tree
        if(left_H == -1 || right_H == -1 || abs(left_H-right_H) > 1 )
            return -1 ;
        
        //If left and right subtree are balanced then simply returning the height
        return 1+max(left_H,right_H);
        
    }
    bool isBalanced(TreeNode* root) {
        return height(root) != -1;
    }
};