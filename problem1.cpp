// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we maintain an array to store our path to each node and update it whnever we leave it or reach it.
// during this process, we check if we reached leaf node and if we reached our targetSum , then we store that array in our result.


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
    vector<vector<int>>  result;
    void func(TreeNode* root, int targetSum,int curr_sum,vector<int> &currList)
    {
        if(root==NULL)
        {
            return;
        }
        curr_sum+= root->val;
        if(root->left==NULL && root->right==NULL)
        {
            if(curr_sum == targetSum)
            {
                currList.push_back(root->val);
                result.push_back(currList);
                currList.pop_back();
            }
            return;
        }
        currList.push_back(root->val);
        func(root->left,targetSum,curr_sum,currList);
        func(root->right,targetSum,curr_sum,currList);
        currList.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(root==NULL) return {};
        vector<int> v;
        func(root,targetSum,0,v);
        return result;
    }
};