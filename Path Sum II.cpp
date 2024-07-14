// time: O(n)
// space: O(log n); worst case O(n)

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
    vector<vector<int>> result;
    void helper(TreeNode* root, int targetSum, int sum, vector<int> vec) {
        if(root == NULL) {
            return;
        }
        //vector<int> vec;
        vec.push_back(root -> val);
        sum += root -> val;
        if(root -> left == NULL && root -> right == NULL) {
            if(sum == targetSum) {
                result.push_back(vec);
                
            }
            return;

        }
        helper(root -> left, targetSum, sum, vec);
        helper(root -> right, targetSum, sum, vec);
        
    }
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        helper(root, targetSum, 0, {});
        return result;
    }
};