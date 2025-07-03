// Time complexity O(n)
// Space complexity O(h)

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
        if (root == nullptr) {
            return true;
        }
        return isEqual(root->left, root->right);
    }

    bool isEqual(TreeNode* p, TreeNode* q) {
        if (p == nullptr && q == nullptr) {
            return true;
        }
        if (p == nullptr) {
            return false;
        }
        if (q == nullptr) {
            return false;
        }
        if (p->val != q->val) {
            return false;
        }
        return isEqual(p->left, q->right) && isEqual(p->right, q->left);
    }
};