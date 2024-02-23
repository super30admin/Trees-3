// 101. Symmetric Tree
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
initializes a global flag to indicate symmetry and calls a DFS helper function on the left and right subtrees of the root.
During traversal, if any of the following conditions are met: left node is null and right node is not null, right node is 
null and left node is not null, or the values of corresponding nodes do not match,  sets the flag to false. Otherwise, 
recursively checks symmetry by comparing the left subtree of the left node with the right subtree of the right node, and vice versa.
*/
class Solution {
public:
    bool flag = true;
    bool isSymmetric(TreeNode* root) {
        if(root == NULL) return flag;
        dfs(root->left, root->right);
        return flag;
    }
    void dfs(TreeNode* left, TreeNode* right)
    {
        if(left == NULL && right == NULL) return;

        if(left == NULL || right == NULL || left->val != right->val)
        {
            flag = false;
            return;
        }
        dfs(left->left, right->right);
        dfs(left->right, right->left);
        return;
    }
};