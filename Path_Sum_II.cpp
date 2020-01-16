Time Complexity-O(n)
Space Complexity-O(h)+space taken by vectors which are not returned in the output vector.
Did the code run on Leetcode? Yes

class Solution {
public:
    vector<vector<int>>m;
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int>k;
        findsum(root,k,sum);
        return m;
    }
    void findsum(TreeNode *root,vector<int>k,int sum)
    {
        if(root==NULL)
        {
            return;+
        }
        k.push_back(root->val);
        if(root->left==NULL && root->right==NULL)
        {
            int sum1=0;
            for(int i=0;i<k.size();i++)
            {
                sum1+=k[i];
            }
            if(sum1==sum)
            {
                m.push_back(k);
            }
        }
        findsum(root->left,k,sum);
        findsum(root->right,k,sum);
    }
};