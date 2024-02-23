// 113. Path Sum II
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
utilizes a recursive helper function that traverses the tree nodes while maintaining the current sum and the path from 
the root to the current node. When a leaf node is reached, if the current sum matches the target sum, the path is added 
to the answer. explores both the left and right subtrees recursively and backtracks by removing the last node from 
the current path to explore other paths.
*/
class Solution {
public:
    vector<vector<int>> ans;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> path;
        helper(root, targetSum, 0, path);
        return ans;
    }
    void helper(TreeNode* root, int targetSum, int currentSum, vector<int> path)
    {
        if(root == NULL)
            return;
        currentSum += root->val;
        path.push_back(root->val);
        if(root->left == NULL && root->right == NULL)
        {
            if(currentSum == targetSum)
                ans.push_back(path);
            return;
        }
        helper(root->left, targetSum, currentSum, path);
        helper(root->right, targetSum, currentSum, path);
        path.pop_back();
    }

};