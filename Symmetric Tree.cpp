// time: O(n)
// space: O(1)

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
    bool ans = true;
    void helper(TreeNode* root1, TreeNode* root2) {
        if(root1 == NULL) {
            if(root2 == NULL) {
                return;
            }
            else {
                ans = false;
                return;
            }
            
        }
        else if(root2 == NULL) {
            
            ans = false;
            return;
            
            
        }
        else if(root1 -> val != root2 -> val) {
            ans = false;
            return;
        }
        helper(root1 -> left, root2 -> right);
        helper(root1 -> right, root2 -> left);
    }
public:
    bool isSymmetric(TreeNode* root) {
        helper(root -> left, root -> right);
        return ans;
    }
};