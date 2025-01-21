// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Path Sum II
// Approach: DFS and Backtracking
// Time Complexity: O(n)
// Space Complexity: O(h)

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

class Solution
{
public:
    // Result Array
    vector<vector<int>> results;

    vector<vector<int>> pathSum(TreeNode *root, int targetSum)
    {

        // Base Case
        if (root == NULL)
        {
            return results;
        }

        vector<int> path;

        // Call DFS Function
        dfs(root, path, 0, targetSum);

        return results;
    }

    void dfs(TreeNode *root, vector<int> &path, int sum, int targetSum)
    {

        // Base Case
        if (root == NULL)
        {
            return;
        }

        // Calculate Sum and Add to path sum
        sum += root->val;
        path.push_back(root->val);

        // Logic to check if the node is leaf node
        if (root->left == NULL && root->right == NULL)
        {

            // Check if sum matches the tagetSum
            if (sum == targetSum)
            {

                // Copy the path to temp vector as we have passed by reference
                vector<int> res = path;

                // Push to results array
                results.push_back(res);
            }

            // Remove from path which is passed by reference
            path.pop_back();

            return;
        }

        // Continue with childs if current node is not the leaf node
        dfs(root->left, path, sum, targetSum);
        dfs(root->right, path, sum, targetSum);

        // Pop the value as we have visited this node
        path.pop_back();
    }
};