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

/*
Time: O(N) (O(N^2) worst case for skewed tree)
Space: O(N^2) worst case

Traverse the array, add value to path, decrease value from sum and whenever we reach leaf and sum becomes zero, add path to result
Then backtrack
*/

class Solution {
public:
    vector<vector<int>> ret;
    vector<int> path;
    
    void call(TreeNode* root, int sum){
      if(root==nullptr)  return;
      if(sum<0)  return;

      
      path.push_back(root->val);
      sum = sum - root->val;

      if(sum==0 && root->left == nullptr && root->right == nullptr){
        ret.push_back(path);
      }
      
      call(root->left, sum);
      call(root->right, sum);
      path.pop_back(); //backtrack
    }

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        call(root, targetSum);

        return ret;
    }
};
