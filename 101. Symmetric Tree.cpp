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
Time: O(N)
Space: O(h) (recursion stack space)

Maintain two pointers (two nodes). The left subtree of left node and right subtree of right node,
should be identical, and the right subtree of left node and the left subtree of right node should be identical 
*/
class Solution {
public:
    bool call(TreeNode* r1, TreeNode* r2){
      //both null -> end of subtree
      if(r1==nullptr && r2==nullptr)  return true;
      //one is null -> premature end of one subtree
      if(r1==nullptr || r2==nullptr)  return false;

      if(r1->val != r2->val)  return false;

      //recursive check for symmetricity of subtrees
      return call(r1->left, r2->right) && call(r1->right, r2->left);

    }

    bool isSymmetric(TreeNode* root) {
      //call for the two nodes : left and rights
      return call(root->left, root->right);

    }
};
