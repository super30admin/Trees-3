/*Recursively explore paths in the binary tree, maintaining a running sum and a list of nodes for each path.
If a leaf node is reached with a sum equal to the target, add the path to the list of paths.
Return the list of paths containing nodes whose values sum to the target.
Time Complexity: O(N), where N is the number of nodes in the binary tree. Each node is visited once.
Space Complexity: O(H), where H is the height of the binary tree. The space complexity is determined by the recursive call stack, which is at most the height of the tree for a balanced tree.*/
#include<bits/stdc++.h>
using namespace std;
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
    void recurseTree(TreeNode* node, int remainingSum, vector<int>& pathNodes, vector<vector<int>>& pathsList) {
        if (node == nullptr) {
            return;
        }

        pathNodes.push_back(node->val);

        if (remainingSum == node->val && node->left == nullptr && node->right == nullptr) {
            pathsList.push_back(pathNodes);
        } else {
            recurseTree(node->left, remainingSum - node->val, pathNodes, pathsList);
            recurseTree(node->right, remainingSum - node->val, pathNodes, pathsList);
        }

        pathNodes.pop_back();
    }
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> pathsList;
        vector<int> pathNodes;
        recurseTree(root, targetSum, pathNodes, pathsList);
        return pathsList;
    }
};