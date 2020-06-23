//Time Complexity: O(N), where n is the elements in the tree.
//Space Complexity: O(h), where h is the height of the tree.

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {

vector<int> global;
vector<vector<int>> result;
private:
    void helper(TreeNode* root, int target ,int curr_sum){
            
            //base
            if(root==NULL) return ;
            global.push_back(root->val);
            curr_sum += root->val;
            if(root->left == NULL && root->right == NULL){
                if(curr_sum == target){
                    result.push_back(global);
                }
            }
            else{
                helper(root->left,target,curr_sum);
                helper(root->right,target,curr_sum);
            }
        global.pop_back();
    }
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        helper(root, sum, 0);
        return result;
    }
};