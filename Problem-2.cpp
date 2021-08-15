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
 Time Complexity = O(N)
 Space Complexity = O(h)
 Where N is the number of nodes in the tree and h is the height of the tree.
 */
class Solution {
public:
    bool helper(TreeNode* left, TreeNode* right)
    {
        if(left==NULL && right==NULL)
            return true;
        if(left==NULL || right==NULL || left->val != right->val)
            return false;   
        return helper(left->left, right->right) &&  helper(left->right, right->left);
    }
    bool isSymmetric(TreeNode* root) {
        return helper(root->left,root->right);
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
 Time Complexity = O(N)
 Space Complexity = O(h)
 Where N is the number of nodes in the tree and h is the height of the tree.
 */
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        stack<TreeNode*> s;
        s.push(root->left);
        s.push(root->right);
        while(!s.empty())
        {
            TreeNode* right1 = s.top();
            s.pop();
            TreeNode* left1 =  s.top();
            s.pop();
            if(left1==NULL && right1==NULL)                             //here it is continue because we dont want to stop when NULL is encountered on both the nodes of the tree.
                continue;
            if(left1==NULL || right1==NULL || left1->val != right1->val)
                return false;
            s.push(left1->left);
            s.push(right1->right);
            s.push(left1->right);
            s.push(right1->left);
        }
        return true;
    }
};
