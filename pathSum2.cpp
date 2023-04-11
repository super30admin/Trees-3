class Solution {
    // TC - O(n)
    // Sc - O(h) height of tree
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> list;
        vector<vector<int>> result;
        pathSum2(root, targetSum,0, list, result);
        return result;
    }
    void pathSum2(TreeNode* root, int targetSum, int cummulativeSum, vector<int> &listSoFar, vector<vector<int>> &result ){
        if(root == NULL) return ;
        cummulativeSum= (cummulativeSum) + root->val;
        listSoFar.push_back(root->val);        
        if(root->left == NULL && root->right ==NULL && cummulativeSum == targetSum){
            result.push_back(listSoFar);
            listSoFar.erase(listSoFar.end()-1);
            return;
        }
        pathSum2(root->left, targetSum,cummulativeSum,listSoFar,result);
        pathSum2(root->right, targetSum,cummulativeSum,listSoFar,result);
        listSoFar.erase(listSoFar.end()-1);
        return;
    }
};