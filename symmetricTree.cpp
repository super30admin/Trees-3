// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Recursive approach. Tree is symmetric if left of left tree is equal to right of right tree && right of left tree is equal to left of right tree
// 2. Call Helper function with two nodes both as root. Helper will return true if both are true
// 3. If both roots are not null and have same value then recursively call for above sub-trees

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        return isMirror(root, root);
    }
    
    bool isMirror(TreeNode* root1, TreeNode* root2){
        if(root1 == nullptr && root2 == nullptr)
            return true;
        
        if(root1 && root2 && root1->val == root2->val)
            return (isMirror(root1->left, root2->right) && isMirror(root1->right, root2->left));
        
        return false;
    }
};