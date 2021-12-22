//Time complexity : O(n)
//Space complexity : O(h)

//Approach :
            // Calculate summation while going through the entire tree at each node
            // Also keep track of all the nodes visited in this path
            // Check whether it is leaf node or not
            // If it is leaf node, then add all the elements visited till now into an array
            // Return the array

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
        vector<vector<int>> returnValue;
        if(root == nullptr)
            return returnValue;
        vector<int> path_array(0);
        path(root, 0, targetSum, path_array, returnValue);
        return returnValue;
    }
    
    void path(TreeNode* root, int sum, int targetSum, vector<int> path_array, vector<vector<int>>& returnValue)
    {
        if(root == nullptr)
        {
            return;
        }
        
        sum += root->val;
        path_array.push_back(root->val);
        
        if(root->left == nullptr && root->right == nullptr)
        {
            if(sum == targetSum)
            {
                returnValue.push_back(path_array);
            }
        }
        
        path(root->left, sum , targetSum, path_array, returnValue);
        path(root->right, sum , targetSum, path_array, returnValue);
        
        path_array.pop_back();
    }
};