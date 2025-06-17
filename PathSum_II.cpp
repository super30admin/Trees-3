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

  
// We use DFS and backtracking to explore all root-to-leaf paths in the binary tree.

// At each node, we add the value to the current path and sum.

// When a leaf node is reached, we check if the path sum equals targetSum.

// If it does, we store the path in result.

// After exploring both subtrees, we backtrack by removing the last node from the path.

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int>path;
        helper(root, targetSum, 0, path);
        return result;
    }

    void helper(TreeNode* root, int targetSum, int currSum, vector<int>& path) {
        if (root == nullptr) return;
        currSum += root->val;
        path.push_back(root->val);
        if (root->left == nullptr && root->right == nullptr) {
            if (currSum == targetSum) {
                result.push_back(path);
            }
        }
        helper(root->left, targetSum, currSum, path);
        helper(root->right, targetSum, currSum, path);
        path.pop_back();
    }
};