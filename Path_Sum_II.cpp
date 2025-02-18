// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. We will use a helper function to traverse the tree in a DFS manner.
// 2. We will keep track of the current sum and the path from root to leaf node.
// 3. If the current node is a leaf node and the current sum is equal to the target sum, we will add the path to the result which is a global variable.
// 4. We will recursively call the helper function on the left and right child of the current node.
// 5. We will backtrack by popping the last element from the path.

class Solution {
    private: 
        vector<vector<int>> result;
        void helper(TreeNode* root, int targetSum, int currSum, vector<int>& path){
            //base case
            if(root == nullptr){
                return;
            }
            currSum += root -> val;
            path.push_back(root -> val);
            if(root -> left == nullptr && root -> right == nullptr && currSum == targetSum){
                result.push_back(path);
            }
            helper(root -> left, targetSum, currSum, path);
            helper(root -> right, targetSum, currSum, path);
            path.pop_back();
        }
    public:
        vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
            vector<int> path;
            helper(root, targetSum, 0, path);
            return result;
        }
    };