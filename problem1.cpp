#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;


 //Definition for a binary tree node.
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
  void visit(TreeNode* node, int sum, vector<int>& prefix, vector<vector<int>>& paths) {
    if (node) {
      sum -= node->val;
      prefix.push_back(node->val);
      if (node->left == nullptr and node->right == nullptr and sum == 0) {
        paths.push_back(prefix);
      }
      else {
        visit(node->left , sum, prefix, paths);
        visit(node->right, sum, prefix, paths);
      }
      prefix.pop_back();
    }
  }
  
 public:
  vector<vector<int>> pathSum(TreeNode* root, int sum) {
    auto paths = vector<vector<int>>();
    auto prefix = vector<int>();
    visit(root, sum, prefix, paths);
    return paths;
  }
};