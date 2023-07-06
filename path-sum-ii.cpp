// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

//Implementing a tree class
class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

// Using global vector and local vector to store path of the targeted sum and then appending it to the global path vector. 
class Solution {
private:
    vector<vector<int>> globalPath;
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> localPath;
        helper(root, 0, localPath, targetSum);
        return globalPath;
    }
    void helper(TreeNode* root, int localSum, vector<int> localPath, int target){
        //base
        if(root == nullptr) return;
        if(root->left == nullptr && root->right == nullptr){
            localSum += root->val;
            localPath.push_back(root->val);    
            if(localSum == target){
                globalPath.push_back(localPath);
            }
        }
        localSum += root->val;
        localPath.push_back(root->val);
        //left
        helper(root->left, localSum, localPath, target);

        //right
        helper(root->right, localSum, localPath, target);

        localPath.pop_back();
    }
};