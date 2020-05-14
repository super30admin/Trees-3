//Time Complexity-O(n)
//Space Complexity-O(h)
//Ran successfully on leetcode
/*3 point algo -
	1.We traverse throgh the tree recursively, add all the nodes we encounter into a vector and add the sum till the leaf.
	2.Once we reach a leaf node, we check if the sum we calculated is equal to the target. If yes, we add the vector to our resultant 2D vector.
	3.If not, then we delete the last element in our vector, backtrack to the previously visited node and traverse the right subtree.*/
	
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
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>>result;
        vector<int>temp;
        if(root==NULL)
            return {};
        helper(root,sum,temp,result,0);
        return result;
    }
    void helper(TreeNode *root,int sum,vector<int>&temp,vector<vector<int>>&result,int s)
    {
        //base case
        if(root==NULL)
            return;
		//logic
        temp.push_back(root->val);
        s=s+root->val;
        if(root->left==NULL && root->right==NULL && sum==s)
            result.push_back(temp);
        helper(root->left,sum,temp,result,s);
        helper(root->right,sum,temp,result,s);
        temp.pop_back();
    }
    
};