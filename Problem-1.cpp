// Time Complexity : O(n) where n is number of nodes in the tree, this is becuase we're just doing inorder traversal and computing result
// Space Complexity : O(h) h is height of the tree and first h is space reqrd for recursion stack space, space for list is not considered
//                    as it is returned as output
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

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
    vector<vector<int>> res;
    vector<int> interm_res;
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        int curr_sum = 0;
        
        inorder(root, curr_sum, targetSum);
        return res;
    }

    void inorder(TreeNode* root, int curr_sum, int targetSum)
    {
        if(root == NULL)
            return;

        interm_res.push_back(root->val);
        inorder(root->left, curr_sum+root->val, targetSum);
        if(root->left == NULL && root->right == NULL)
        {
            if(curr_sum+root->val == targetSum)
            {
                res.push_back(interm_res);
            }
        }
        inorder(root->right, curr_sum+root->val, targetSum);
        interm_res.erase(interm_res.begin()+interm_res.size()-1);
    }
};