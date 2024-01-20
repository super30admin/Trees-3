// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using dfs, start comparing both left and right side of the tree.

#include <bits/stdc++.h>
using namespace std;


 // Definition for a binary tree node.
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };


class Solution {
public:
    bool flag;
    void dfs(TreeNode* left,TreeNode* right){
        if(left == NULL && right == NULL) return;
        if(left == NULL || right == NULL || left->val != right->val){
             flag = false;
             return;
        }
        dfs(left->left,right->right);
        dfs(left->right,right->left);
    }
    bool isSymmetric(TreeNode* root) {
        if(root == NULL) return true;
        flag = true;
        dfs(root->left,root->right);
        return flag;
    }
};