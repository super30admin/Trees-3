//Time Complexity O(n)
// Space Complexity O(height of tree)(Due to recursion)
//Problem successfully executed on leetcode
//No problems faced while coading this.



#include<iostream>
#include<vector>
using namespace std;

  struct TreeNode {
     int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class Solution {
public:
    vector<vector<int> > result;
    vector<vector<int> > pathSum(TreeNode* root, int targetSum) {
        vector<int> currentList;
        CalculateSum(root, targetSum,0,currentList);
        return result;
    }
    
    void CalculateSum(TreeNode* root, int targetSum,int currentSum,vector<int> currentList)
    {
        if(root==NULL)
        {
            return;
        }
        currentSum+=root->val;
        currentList.push_back(root->val);
        if(root->left==NULL && root->right==NULL && currentSum==targetSum)
        {
            vector<int> copyVector;
            copyVector=currentList;
            result.push_back(copyVector);
        }
        CalculateSum(root->left,targetSum,currentSum,currentList);
        CalculateSum(root->right,targetSum,currentSum,currentList);
        currentList.pop_back();
    }
};