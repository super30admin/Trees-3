// Time Complexity: O(n)
// Space Complexity: Size of Recursive Stack (height of tree) + O(n)

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
public:
    vector<vector<int>> result; 
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(root == nullptr) return {};
        vector<int> path; 
        SumToPaths(root, 0, targetSum, path);

        return result; 
    }

    void SumToPaths(TreeNode* node, int currentSum, int targetSum, vector<int>& path) {
        
        currentSum += node->val; 
        path.push_back(node->val);

        if(node->left == nullptr && node->right == nullptr) {
            if(currentSum == targetSum) result.push_back(path);
            path.pop_back(); 
            return; 
        }

        if(node->left != nullptr) SumToPaths(node->left, currentSum, targetSum, path);
        if(node->right != nullptr) SumToPaths(node->right, currentSum, targetSum, path);
        path.pop_back(); 
    }
};