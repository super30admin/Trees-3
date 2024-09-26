//Time Complexity: O(N), where n is the elements in the tree.
//Space Complexity: O(N), where n is the elements in the tree.

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
private:
    bool helper(TreeNode* L, TreeNode* R){
         if(L==nullptr && R==nullptr) return true;
         if(L== nullptr || R== nullptr || L->val != R->val) return false;
         return helper(L->right, R->left) && helper(L->left, R->right);
    }
public:
    bool isSymmetric(TreeNode* root) {
            if(root==nullptr) return true;
            return helper(root->left, root->right);
    }
};