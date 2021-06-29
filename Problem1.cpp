
// Time Complexity :  O(n)
// Space Complexity :  O(n) System stack for recursion + one result array, path array is passed by reference hence not considered
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Path Sum II


#include<iostream>
#include<vector>
using namespace std;

 struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };
 
class Solution {
private: 
    vector<vector<int>> result;
    int targetDiff;

public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        
        vector<int> temp;
        targetDiff = targetSum;
        helper(root, targetSum, temp);
        return result;
        
    }
    
    void helper(TreeNode* root, int targetDiff, vector<int> &path){
        
        if(root == NULL)    // terminating condition
            return;
        
        targetDiff = targetDiff - root->val;
        path.push_back(root->val);
        helper(root->left, targetDiff, path);       
        helper(root->right, targetDiff, path);
        
        if(root->left == NULL && root->right == NULL){
            if(targetDiff == 0)
                result.push_back(path);
        }
        
        path.pop_back();    //back track
    }
};