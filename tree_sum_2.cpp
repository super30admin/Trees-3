Time Complexity O(N) , n is number of nodes
Space Complexity O(H) , h is the height of the tree.

class Solution {
public:
    vector<vector<int>> result ; 
    vector<int>path ; 
    int target ; 
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {

        target = targetSum ; 
        traverse(root,0,path) ; 

        return result ; 
    }

    void traverse(TreeNode* root,int sum,vector<int> path){ 
        if(root == NULL){
            return  ; 
        }
        sum = sum + root->val ; 
        path.push_back(root->val) ; 
        if(root->left == NULL && root->right == NULL){
            if(sum == target){
                result.push_back(path) ; 
            }

            return ; 
        }

        traverse(root->left,sum,path) ; 
        traverse(root->right,sum,path) ; 
    }
};
