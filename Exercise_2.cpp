// Time Complexity                              :  O(N/2) = O(N) since we are comparing two nodes at a time.
// Space Complexity                             :  O(H) where H is the height of the tree.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/symmetric-tree/submissions/

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
        if(!root) return true;
        return isSym(root->left,root->right);
    }
    
    bool isSym(TreeNode *left, TreeNode *right) {
        if(left == NULL and right == NULL) return true;
        if(left == NULL or right == NULL or left->val != right->val) return false;
        return isSym(left->left,right->right) and isSym(left->right, right->left);
    }
};