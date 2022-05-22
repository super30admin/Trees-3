//TC = O(N)
//SC = O(H)

class Solution {
public:
    int sum = 0;
    bool flag = 0;
    bool hasPathSum(TreeNode* root, int targetSum) {
        int localSum = 0;
        helper(root,0,targetSum);
        return flag;
    }
    
    void helper(TreeNode* root, int localSum,int targetSum){
        if(root ==NULL) return;
        if(root->left==NULL && root->right==NULL){
            localSum = localSum+ root->val;
            if(localSum==targetSum) {
                flag = true;
                return;
            }
        }
        if(flag==false)
            helper(root->left,localSum + root->val,targetSum);
        if(flag==false)
            helper(root->right,localSum + root->val,targetSum);
    }
};
