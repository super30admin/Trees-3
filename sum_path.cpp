//TC: O(n) where n is number of nodes
//SC: O(n) where n is number of nodes.

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
    
    vector<vector<int>> paths;
    //pass vector by reference. 
    void findPaths(TreeNode* node, int target, int curr, vector<int> &path) {
        if (node == NULL)
            return;
        curr += node->val;
        path.push_back(node->val);
        if (curr == target && node->left == node->right)
            paths.push_back(path);
        
        findPaths(node->left, target, curr, path);
        findPaths(node->right, target, curr, path);
        //when we reach a left leaf node, pop the leaf node to go back to root.
        path.pop_back();
    }
    
    
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> path;
        findPaths(root, targetSum, 0, path);
        return paths;
    }
};