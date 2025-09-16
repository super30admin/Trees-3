// Problem - Path sum ii
//  Time Complexity : O(n)
//  Space Complexity : O(n) where n is the height of the tree
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We recurse on the tree and keep recording the path in the vector
// 2. We keep subtracting the targetSum with root->val and if we are at the leaf
// node and targetSum is zero we add it to our path
// 3. We can do any kind of traversal but we need to first add the current
// node's value and then traverse so that valid path doesn't get skip

#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 */

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};

/**
 * Definition for a binary tree node.
 */
class Solution {
public:
  vector<vector<int>> result;
  vector<vector<int>> pathSum(TreeNode *root, int targetSum) {
    helper(root, targetSum, {});
    return result;
  }

  void helper(TreeNode *root, int targetSum, vector<int> res) {
    if (!root)
      return;
    res.push_back(root->val);
    targetSum -= root->val;
    if (root->left == nullptr && root->right == nullptr && targetSum == 0) {
      result.push_back(res);
    }
    helper(root->left, targetSum, res);
    helper(root->right, targetSum, res);
  }
};
