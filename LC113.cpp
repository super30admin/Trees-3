// Time complexity O(n)
// Space complexity O(h)

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
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> result;
        vector<TreeNode*> curr;
        curr.push_back(root);
        pathSum(root, targetSum, curr, result);
        return result;
    }

    void pathSum(TreeNode* root, int targetSum, vector<TreeNode*>& curr, vector<vector<int>>& result) {
        if (root == nullptr) {
            return;
        }
        if (root->left == nullptr && root->right == nullptr) {
            int sum = 0;
            vector<int> res;
            for (TreeNode* node : curr) {
                if (node != nullptr) {
                    sum += node->val;
                    res.push_back(node->val);
                }
            }
            if (sum == targetSum) {

                result.push_back(res);
            }
            return;
        }

        curr.push_back(root->left);
        pathSum(root->left, targetSum, curr, result);
        curr.pop_back();

        curr.push_back(root->right);
        pathSum(root->right, targetSum, curr, result);
        curr.pop_back();
    }
};