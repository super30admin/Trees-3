//Time O(n)
 //Space O(n)
 //Leetcode yes
 //Issue seen: None
 //
class Solution {
public:
    bool isSame(TreeNode* p, TreeNode* q){
        if(!p && !q) return true;
        if(!p || !q) return false;
        if(p->val != q->val){
            return false;
        }
        return (isSame(p->left, q->right) && isSame(p->right, q->left));

    }
    bool isSymmetric(TreeNode* root) {
        if(!root) return true;
        
        return (isSame(root->left, root->right));
    }
};
