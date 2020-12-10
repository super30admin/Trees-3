//Time complexity - O(n) n= number of nodes
//Space complexity - O(n)

class Solution {
public:
    void sumPath(TreeNode* root,int &sum,vector<vector<int>> &result,int curr,vector<int> res){
        if(!root) return;
        curr+=root->val;
        res.push_back(root->val);
        if(curr==sum && !root->left && !root->right){
            result.push_back(res);
            return;
        }
        sumPath(root->left,sum,result,curr,res);
        sumPath(root->right,sum,result,curr,res);
        res.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> result;
        if(!root) return result;
        vector<int> res;
        sumPath(root,sum,result,0,res);
        return result;
    }
};