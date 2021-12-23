// Time Complexity : 
//    Worst case - O(n*n) -> All path sums up to target sum. Every time all path variables will be copied.
//    Average case - O(n)
// Space Complexity : O(h)
//   Where h is height of tree. 
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Maintain the path vector to store current path.
 * Pass the current sum and target sum to all child nodes by calling recursive function.
 * If current node is child node and sum is equal to target sum then copy the path vector into answers vector.
 * Return the answers vector.
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
class Solution {
public:
    vector<vector<int>> answers;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if (root == nullptr)
            return {};
        
        vector<int> path;
        helper(root, targetSum, 0, path);
        return answers;
    }
    
    void helper(TreeNode* root, int targetSum, int sum, vector<int> path)
    {
        if (root == nullptr)
            return;
        
        sum += root->val;
        path.push_back(root->val);
        
        if (root->left == nullptr && root->right == nullptr)
        {
            if (targetSum == sum)
            {
                answers.push_back({path.begin(), path.end()});
            }
        }
        
        helper(root->left, targetSum, sum, path);
        helper(root->right, targetSum, sum, path);
        
        path.pop_back();
    }
};