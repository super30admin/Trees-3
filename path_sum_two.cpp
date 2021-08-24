// Time Complexity :O(n)
// Space Complexity :O(height of tree)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// traverse the tree recursively in a preorder fashion
// add value to curr sum and add the node to the path
// if its a lead and curr sum equals target just add it to the result array
// after completing the left and right recursive calls bactrack by removing the node from the path

class Solution {
public:
    vector<vector<int>> answer={};
    int target;
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        target= sum;
        vector<int>curr;
        helper(root,0,curr);
        return answer;
    }
        void helper(TreeNode* root,int curr_sum,vector<int>&path){
        if(root==nullptr){
            return;
        }
        path.push_back(root->val);
        curr_sum+=root->val;
        if(!root->left && !root->right  && curr_sum==target){
            answer.push_back(path);
            
        }
        
        helper(root->left,curr_sum,path);
        helper(root->right,curr_sum,path);
          
        path.pop_back();
    }
  
    
};