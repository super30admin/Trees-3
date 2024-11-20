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
    vector<vector<int>>result;
public:
    void helper(TreeNode* root,vector<int>list, int currSum ,int targetSum)
    {
        //base case
        if(root == NULL)
            return;

        list.push_back(root->val);
        currSum += root->val;
        if(currSum == targetSum & !root->left && !root->right)
            result.push_back(list);
        helper(root->left,list,currSum,targetSum);
        helper(root->right,list,currSum,targetSum);

    }
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        
        vector<int>list;
        int currSum =0;
        helper(root,list,currSum,targetSum);
        return result;
    }
};

//Time complexity O(N)
//Space complexity O(h)