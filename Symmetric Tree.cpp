// TC = O(N)
// SC = O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
    bool isSymmetric(TreeNode* root) {
        // // BFS
        // // TC = O(N)
        // // SC = O(N)
        // queue<TreeNode*> q;
        // q.push(root->left);
        // q.push(root->right);
        // while(!q.empty()) {
        //     TreeNode* left = q.front(); q.pop();
        //     TreeNode* right = q.front(); q.pop();
        //     if(left == nullptr && right == nullptr) continue;
        //     if(left == nullptr || right == nullptr || left->val != right->val) return false;
        // // putting in order of checking left's left with right's right & left's right with right's left
        //     q.push(left->left); q.push(right->right);
        //     q.push(left->right); q.push(right->left);
        // }
        // return true;

        // DFS
        // TC =O(N)
        // SC =O(H)
        return dfs(root->left, root->right);
    }
    bool dfs(TreeNode* left, TreeNode* right) {
        // base
        if(left == nullptr && right == nullptr) return true;
        // logic
        if(left == nullptr || right == nullptr || left->val != right->val) return false;
        // putting in order of checking left's left with right's right & left's right with right's left
        return dfs(left->left, right->right) && dfs(left->right, right->left);
    }
};