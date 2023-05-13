


// Iterative approach

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// we dont need to check root, we need to start checking root->left and root->right.
// we take a queue with these two nodes ( root->left and root->right) we then keep on checking the values.


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
        if(root==NULL) return true;
        queue<TreeNode*>q;
        q.push(root->left);
        q.push(root->right);
        while(!q.empty())
        {
            TreeNode* left = q.front();
            q.pop();
            TreeNode* right = q.front();
            q.pop();
            if(left==NULL && right==NULL){
                continue;
            }
            if(left==NULL || right==NULL) {
                return false;
            }
            if(left->val!=right->val){
                return false;
            }
            q.push(left->left);
            q.push(right->right);
            q.push(left->right);
            q.push(right->left);
        }
        return true;
    }
};

// Recursive approach
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we write a function which  checks whether two subtrees are symmetric or not i.e., root->left and root->right;
// we recurrsively call them untill base condition is reached .


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
    bool dfs(TreeNode* left, TreeNode* right)
    {
        if(left==NULL && right==NULL){
            return true;
        } 
        if(left==NULL || right==NULL){
            return false;
        }
        if(left->val!=right->val)
        {
            return false;
        }
        return dfs(left->left,right->right) && dfs(left->right,right->left);
    }
    
    bool isSymmetric(TreeNode* root) {
        if(root==NULL) return true;
        return dfs(root->left, root->right);
    }
    
};