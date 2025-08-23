#include<iostream>
#include<bits/stdc++.h>
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
/*
We use recursion to explore all root-to-leaf paths while accumulating the sum and tracking the path.
If we reach a leaf and the current sum equals the target, we add a copy of the path to the result.
After recursive calls, we backtrack by removing the last element to restore the path for other branches
*/
class Solution{
public:
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> path;
        helper(root, targetSum, 0, path);
        return result;
    }

private:
    void helper(TreeNode* root, int& targetSum, int currSum, vector<int>& path){
        if(root==nullptr) return;

        currSum+=root->val;
        path.push_back(root->val);

        if(root->left == nullptr && root->right == nullptr){
            if(currSum == targetSum){
                result.push_back(path);
            }
        }

        helper(root->left,targetSum,currSum,path);
        helper(root->right,targetSum,currSum,path);

        path.pop_back();
    }
};
