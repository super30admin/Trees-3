// Approach 1 - void based DFS
// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(h) - recursive stack
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    bool flag;
    private:
    void dfs(TreeNode* nodeL, TreeNode* nodeR){
        if(nodeL == NULL && nodeR == NULL)
            return;
        if(nodeL == NULL || nodeR == NULL){
            flag = false;
            return;
        }
        if(nodeL->val != nodeR->val){
            flag = false;
            return;
        }
        
        dfs(nodeL->left, nodeR->right);
        if(flag)
            dfs(nodeL->right, nodeR->left);
    }
public:
    bool isSymmetric(TreeNode* root) {
        flag = true;
        dfs(root->left, root->right);
        return flag;
    }
};

// Approach 2 - BFS
// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(n) - Queue space
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root->left);
        q.push(root->right);
        
        while(!q.empty()){
            TreeNode* left = q.front(); q.pop();
            TreeNode* right = q.front(); q.pop();
            
            if(left == NULL && right == NULL) continue;
            if(left == NULL || right == NULL || left->val != right->val)
                return false;
            q.push(left->left); q.push(right->right);
            q.push(left->right); q.push(right->left);
        }
        return true;
    }
};