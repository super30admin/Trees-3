// Time Complexity                              :  O(N) where N is the number of nodes in the tree.
// Space Complexity                             :  O(N) when the tree is skewed. This is the space stored in the functions stack.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;

// https://leetcode.com/problems/path-sum-ii/submissions/

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
private: 
    vector<vector<int>> ans;
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(!root) return ans;
        path(root, vector<int>(),targetSum);
        return ans;
    }
    
    // recursive approach
    void path(TreeNode *root, vector<int> ll, int ts) {
        if(!root) return;
        
        ll.push_back(root->val);
        ts -= root->val;
        
        if(root->left == NULL and root->right == NULL) {
            if(ts == 0) {
                ans.push_back(ll);
                return;
            }
        }
        
        path(root->left,ll,ts);
        path(root->right,ll,ts);
    }
    
    void backTracking(TreeNode *root, vector<int> ll, int ts) {
        if(!root) return;
        
        
        // action
        ll.push_back(root->val);
        ts -= root->val;
    
        
        if(root->left == NULL and root->right == NULL) {
            if(ts == 0) {
                ans.push_back(ll);
                return;
            } 
        }
        
        // recursion
        path(root->left,ll,ts);
        path(root->right,ll,ts);
        
        // backtrack
        ll.pop_back();
        ts += root->val;
    }
    
};