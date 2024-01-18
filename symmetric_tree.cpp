// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach
// Idea here is to do level order traversal using BFS. We add elements in pair,
// and compare them each time we remove it. 

#include <queue>

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
    bool isSymmetric(TreeNode* root) {
        std::queue<TreeNode*> q;
        q.push(root);
        q.push(root);

        while(!q.empty())
        {
            TreeNode* parent1 = q.front();
            q.pop();
            TreeNode* parent2 = q.front();
            q.pop();
            if(parent1 == nullptr && parent2 == nullptr)
            {
                continue;
            }
            if(parent1 == nullptr || parent2 == nullptr || parent1->val != parent2->val)
            {
                return false;
            }

            q.push(parent1->left);
            q.push(parent2->right);
            q.push(parent1->right);
            q.push(parent2->left);
        }

        return true;
    }
};