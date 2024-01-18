// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea here is recursively we calcualte sum until the leaf node and check if its the target. 
// If it is target then push the path to result and backtrack. 


#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
 
class Solution {
public:
    std::vector<std::vector<int>> result;
    std::vector<int> path;
    int target;
    std::vector<std::vector<int>> pathSum(TreeNode* root, int targetSum) {
        target = targetSum;
        helper(root, 0);
        return result;
    }
    void helper(TreeNode* root, int currSum)
    {
        //base 
        if(root == nullptr)
        {
            return;
        }

        //logic
        currSum = currSum + root->val;
        //action
        path.push_back(root->val);
        if(root->left == nullptr && root->right == nullptr)
        {
            if(currSum == target)
            {
                std::vector<int> temp = path;
                result.push_back(path);
            }
        }
        
        //recurse
        helper(root->left, currSum);
        helper(root->right, currSum);

        //backtrack
        path.pop_back();

        return;
    }
};