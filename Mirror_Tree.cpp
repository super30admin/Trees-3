
 //dfs Solution
class Solution {
    bool flag;
public:
    bool isSymmetric(TreeNode* root) {
        flag = true;
        dfs(root->left,root->right);
        return flag;
    }
private:
    void dfs(TreeNode* left_child, TreeNode* right_child){
     //base
        if(left_child==NULL && right_child==NULL)return;
     //logic
        if(left_child==NULL || right_child==NULL ||                     left_child->val!=right_child->val){             
            flag=false;
            return;
        }
        dfs(left_child->left, right_child->right);
        dfs(left_child->right, right_child->left);
    }    
};
/*
Conditional Recursion

 //dfs Solution
class Solution {
    bool flag;
public:
    bool isSymmetric(TreeNode* root) {
        flag = true;
        dfs(root->left,root->right);
        return flag;
    }
private:
    void dfs(TreeNode* left_child, TreeNode* right_child){
     //base
        if(left_child==NULL && right_child==NULL)return;
     //logic
        if(left_child==NULL || right_child==NULL ||                     left_child->val!=right_child->val){             
            flag=false;
            return;
        }
        if(flag){
            dfs(left_child->left, right_child->right);
        }
        if(flag){      
        dfs(left_child->right, right_child->left);
        }
    }    
};

*/
/*
 //bfs solution
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root->left);
        q.push(root->right);
        while(!q.empty()){
            TreeNode* left = q.front();
            q.pop();
            TreeNode* right = q.front();
            q.pop();
            if(left== NULL && right == NULL)continue;
            if(left==NULL || right == NULL || left->val!=right->val)return false;
            q.push(left->left);
            q.push(right->right);
            q.push(left->right);
            q.push(right->left);
        }
        return true;
    }
};
*/
