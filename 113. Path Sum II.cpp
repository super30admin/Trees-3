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
/*
Time Complexity = O(N*N)
Space Complexity = O(N*N)
where N is the number of nodes in the tree.
*/
class Solution {
public:
    vector<vector<int>> result;
    void helper(TreeNode* root, int targetSum, vector<int> path)
    {
        //Base Case
        if(root==NULL)
            return;
        //Logic
        path.push_back(root->val);
        if(root->left==NULL && root->right==NULL)
            if((targetSum-root->val)==0)
            {
                result.push_back(path);
            }
        helper(root->left, targetSum-(root->val),path);                                             //When a vector is passed by value to a function, a copy of the vector is created.
        helper(root->right, targetSum-(root->val),path); 
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(root==NULL)
        {
            vector<vector<int>> x;
            return x;
        }
        vector<int> path;
        helper(root, targetSum, path);
        return result;
    }
};


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
/*
Time Complexity = O(N)
Space Complexity = O(N)
where N is the number of nodes in the tree.
*/
class Solution {
public:
    vector<vector<int>> result;
    void helper(TreeNode* root, int targetSum, vector<int> &path)
    {
        //Base Case
        if(root==NULL)
            return;
        //Logic
        path.push_back(root->val);
        if(root->left==NULL && root->right==NULL)
            if((targetSum-root->val)==0)
            {
                result.push_back(path);
            }
        helper(root->left, targetSum-(root->val),path);                                           //When a vector is passed by reference to a function, it can change your contents of the vector. More efficient than pass by value as copying of vector is avoided.
        helper(root->right, targetSum-(root->val),path); 
        //backtrack
        path.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(root==NULL)
        {
            vector<vector<int>> x;
            return x;
        }
        vector<int> path;
        helper(root, targetSum, path);
        return result;
    }
};
