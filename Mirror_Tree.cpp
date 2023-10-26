
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
