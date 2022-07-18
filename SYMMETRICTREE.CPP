class Solution {
public:
    //TC-0(N)
    //SC-0(N)
    bool isSymmetric(TreeNode* root) {
        if(!root)return true;
        queue<TreeNode*> q;
        q.push(root->left);
        q.push(root->right);
        while(!q.empty()){
            auto l=q.front();q.pop();
            auto r=q.front();q.pop();
            if(!l&&r)return false;
            if(l&&!r)return false;
            if(l&&r){
                if(l->val!=r->val)return false;
                q.push(l->left);
                q.push(r->right);
                q.push(l->right);
                q.push(r->left);
            }
        }
        return true;
    }
};