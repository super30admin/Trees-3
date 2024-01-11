/*
 ? Problem: Path Sum 2
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
    std::vector<std::vector<int>> paths;
    void dfs(TreeNode* root, int sum, int& target, std::vector<int>& path) {
        // base
        if (root == nullptr)
            return;

        // logic
        sum += root->val;
        path.push_back(root->val);
        if (sum == target && root->left == nullptr && root->right == nullptr) {
            paths.push_back(path);
        }

        dfs(root->left, sum, target, path);
        dfs(root->right, sum, target, path);
        // backtrack
        path.pop_back();
    }
public:
    std::vector<std::vector<int>> pathSum(TreeNode* root, int targetSum) {
        std::vector<int> path;
        dfs(root, 0, targetSum, path);
        return paths;
    }
};