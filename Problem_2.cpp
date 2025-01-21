// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Symmetric Tree
// Approach: DFS
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
    bool result = true;

    bool isSymmetric(TreeNode *root)
    {
        if (!root)
        {
            return true;
        }

        dfs(root->left, root->right);
        return result;
    }

    void dfs(TreeNode *left, TreeNode *right)
    {
        // Case if the condition has already failed and does not require any more processing
        if (result == false)
        {
            return;
        }

        // Base Case for Leaf Childs
        if (!right && !left)
        {
            return;
        }

        // Case to check Logic if both are present or not
        if ((!left && right) || (left && !right))
        {
            result = false;
            return;
        }

        // Case to check if value matches to mirror
        if (left->val != right->val)
        {
            result = false;
            return;
        }

        // Continue for Childs
        // Call will contain 2 nodes, left and right of child nodes
        dfs(left->left, right->right);
        dfs(left->right, right->left);

        return;
    }
};