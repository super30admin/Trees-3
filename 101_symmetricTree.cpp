// Time Complexity : O(N) where N is the number of nodes.
// Space Complexity :O(H) where h is the number of levels of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//recursive
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root == NULL){
            return true;
        }
        return helper(root->left, root->right);
    }
    bool helper(TreeNode* left, TreeNode* right){
        if(left == NULL && right == NULL){
            return true;
        }
        if(left == NULL || right == NULL || left->val != right->val){
            return false;
        }
        return helper(left->left, right->right) && helper(left->right, right->left);
    }
};
//iterative
// Time Complexity : O(N) where N is the number of nodes.
// Space Complexity :O(H) where h is the number of levels of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root == NULL){
            return true;
        }
        stack<TreeNode*> s;
        s.push(root->left);
        s.push(root->right);
        while(!s.empty()){
            TreeNode* right = s.top();
            s.pop();
            TreeNode* left = s.top();
            s.pop();
            if(left == NULL && right == NULL){
                continue;
            }
            if(left == NULL || right == NULL || left->val != right->val){
                return false;
            }
            s.push(left->left);
            s.push(right->right);
            s.push(left->right);
            s.push(right->left);
        }
        return true;
    }
   
};
