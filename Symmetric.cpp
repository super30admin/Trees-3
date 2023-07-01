// Time Complexity: O(n)
// Space Complexity: Size of Recursive Stack

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
        return CheckEquality(root->left, root->right);
    }

    bool CheckEquality(TreeNode* node1, TreeNode* node2) {
        if(node1 == nullptr && node2 == nullptr) return true; 
        if(node1 != nullptr && node2 == nullptr || node1 == nullptr && node2 != nullptr) return false; 
        if(node1->val != node2->val) return false; 

        bool n1 = CheckEquality(node1->left, node2->right);
        bool n2 = CheckEquality(node1->right, node2->left);

        return n1 && n2; 
    }
};