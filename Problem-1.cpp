class Solution {
public:
    vector<vector<int>> res;  // Our main solution space
    //O(n)+O(h)
    // Just doing simple preOrder Traversal 
    void preOrder(TreeNode* root, int targetSum, vector<int> &sub_res){
        if(root == NULL)
            return;
        sub_res.push_back(root->val);       

        if(!(root->left) && !(root->right) && (targetSum == root->val)) 
            res.push_back(sub_res);

        preOrder(root->left, (targetSum - root->val), sub_res);
        preOrder(root->right, (targetSum - root->val), sub_res);
        
        sub_res.pop_back();  // Backtrack step
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(root == NULL)
            return res;
        vector<int> sub_res;
        preOrder(root, targetSum, sub_res);
        return res;
    }
};
