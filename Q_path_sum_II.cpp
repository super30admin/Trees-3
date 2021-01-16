
//## Problem1 (https://leetcode.com/problems/path-sum-ii/)

//TC-O(n)
//SC- O(n^2)
//Idea- keep maintaining current sum and path

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
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        
        if(root==NULL){
            return result;
        }
        vector<int> currpath;
        helper(root, sum , 0, currpath);
        return result;
    }
    
    void helper(TreeNode* root, int sum , int currsum, vector<int> currpath){
        
        if(root==NULL){
            return;
        }
        
        if(root->left ==NULL && root->right ==NULL){
            int total = currsum + root->val;
            currpath.push_back( root->val);
            if(total == sum){
                result.push_back(currpath);
            }
        }
        
        currpath.push_back(root->val);
        helper(root->left, sum , currsum+ root->val , currpath);
        helper(root->right, sum , currsum+ root->val , currpath);
    }
};



//backtracking

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
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        
        if(root==NULL){
            return result;
        }
        vector<int> currpath;
        helper(root, sum , 0, currpath);
        return result;
    }
    
    void helper(TreeNode* root, int sum , int currsum, vector<int> &currpath){
        
        if(root==NULL){
            return;
        }
        
        if(root->left ==NULL && root->right ==NULL){
            int total = currsum + root->val;
            vector<int> copy;
            for(int i=0;i<currpath.size();i++){
                copy.push_back(currpath[i]);
            }
            copy.push_back( root->val);
            if(total == sum){
                result.push_back(copy);
            }
        }
        
        currpath.push_back(root->val);
        helper(root->left, sum , currsum+ root->val , currpath);
        helper(root->right, sum , currsum+ root->val , currpath);
        currpath.pop_back();
    }
};