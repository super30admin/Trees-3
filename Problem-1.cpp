// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using recursion, traverse till the leaf find the curr sum
// and store the path. Do it for both left and right and backtrack to get the total paths.

// 113

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
    vector<vector<int>> result;
    int target;
    void helper(TreeNode* root, int currSum, vector<int>& path){
        if(root == NULL) return;
        currSum = currSum + root->val;
        path.push_back(root->val);
        if(root->left == NULL && root->right == NULL){
            if(currSum == target){
                result.push_back(path);
            }
        }
        helper(root->left,currSum,path);
        helper(root->right,currSum,path);
        path.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> path;
        target = targetSum;
        helper(root,0,path);  
        return result;
    }
};