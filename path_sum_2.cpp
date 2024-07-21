/*
 *                                  Path Sum II
 *
 * Time Complexity : O(N)
   Space Complexity : O(N)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
   Approach : 
        - Traverse the tree using preorder, inorder or postorder and keep a tally of the targetSum along
          with the node values in the result vector.
*/


#include<iostream>
#include<vector>

using namespace std;

 /* 
  * Definition for a binary tree node.
  */
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
    vector<int> path;
    vector<vector<int>> result;

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        traverse(root, targetSum, 0);
        return result;
    }

    void traverse(TreeNode* root, int targetSum, int sum) {

        if (root == NULL) return;

        sum += root->val;
        path.push_back(root->val);

        if (root->left == NULL && root->right == NULL && targetSum == sum) {
            result.push_back(path);
        }

        traverse(root->left, targetSum, sum);
        traverse(root->right, targetSum, sum);

        path.pop_back();
    }
};