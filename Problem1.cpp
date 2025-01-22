/*
Time Complexity : O(N)
Space Complexity : O(H)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
*/
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
class Solution
{
public:
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode *root, int targetSum)
    {
        // Base Case
        if (root == nullptr)
        {
            return {};
        }
        vector<int> temp;

        // Call DFS Function
        dfs(root, targetSum, 0, temp);
        return result;
    }

    void dfs(TreeNode *root, int targetSum, int currSum, vector<int> temp)
    {

        // Base Case
        if (root == nullptr)
        {
            return;
        }

        // Calculate Sum and Add to path sum
        currSum += root->val;
        temp.push_back(root->val);

        // Logic to check if the node is leaf node
        if (root->left == nullptr && root->right == nullptr)
        {

            // Check if sum matches the tagetSum
            if (currSum == targetSum)
            {

                // Copy the path to temp vector as we have passed by reference
                vector<int> res = temp;

                // Push to results array
                result.push_back(res);
            }

            // Remove from path which is passed by reference
            temp.pop_back();
            return;
        }

        // Continue with childs if current node is not the leaf node
        dfs(root->left, targetSum, currSum, temp);
        dfs(root->right, targetSum, currSum, temp);

        // Pop the value as we have visited this node
        temp.pop_back();
    }
};