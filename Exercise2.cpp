// Problem - Symmetric Tree
//  Time Complexity : O(n)
//  Space Complexity : O(n) where n is the height of the tree
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we take any recursive or iterative approach
// 2. We start with both left and right, and check if both are null then
// continue
// 3. If one of them is null or their values don't match then return false
// 4. Then we add like mirror image left->left and right->right and left->right
// and right->left, in the end return true

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
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
  bool flag = true;
  bool isSymmetric(TreeNode *root) {
    // helper(root->left, root->right);
    // return flag;
    return iterative(root);
  }

  void helper(TreeNode *left, TreeNode *right) {
    if (left == nullptr && right == nullptr)
      return;
    if (left == nullptr || right == nullptr || left->val != right->val) {
      flag = false;
      return;
    }
    helper(left->left, right->right);
    helper(left->right, right->left);
  }

  bool iterative(TreeNode *root) {
    queue<TreeNode *> q;
    q.push(root->left);
    q.push(root->right);
    while (!q.empty()) {
      auto left = q.front();
      q.pop();
      auto right = q.front();
      q.pop();
      if (left == nullptr && right == nullptr)
        continue;
      if (left == nullptr || right == nullptr || left->val != right->val) {
        return false;
      }
      q.push(left->left);
      q.push(right->right);
      q.push(left->right);
      q.push(right->left);
    }

    return true;
  }
};
