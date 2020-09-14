//Recursive solution
// Time Complexity : O(n)
// Space Complexity : O(h) worst case O(n).
//1. Traversal takes place along two paths towards lhs->left , rhs->right and then lhs->right, rhs->left
//2. Check is made to see the values at each level are same
//3. if not return false

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        //edge cae
        if(root ==NULL){
            return true;
        }
        return helper (root->left, root->right);
        
    }
private:
    bool helper(TreeNode* lhs, TreeNode* rhs){
        //base
        if(lhs == NULL && rhs == NULL){
            return true;
        }
        if(lhs ==NULL || rhs==NULL|| lhs->val != rhs->val){
            return false;
        }
        //logic
        return helper(lhs->left, rhs->right) &&  helper(lhs->right, rhs->left);
    }
};\