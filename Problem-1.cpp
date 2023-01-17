

113. Path Sum II

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.



Time Complexity: O(n^2)

where N are the number of nodes in a tree. In the worst case, we could have a complete binary tree and if that is the case, then there would be N/2 leafs. For every leaf, we perform a potential O(N) operation of copying over the pathNodes nodes to a new list to be added to the final pathsList. Hence, the complexity in the worst case could be O(n^2)

Space Complexity: O(N). 
The space complexity, like many other problems is debatable here. I personally choose not to consider the space occupied by the output in the space complexity. So, all the new lists that we create for the paths are actually a part of the output and hence, don't count towards the final space complexity. The only additional space that we use is the pathNodes list to keep track of nodes along a branch.



  class Solution {
      vector<vector<int>> result;
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if (!root) return {};
        vector<int> path;
        helper(root, 0, path, targetSum);
        return result;

    }
        void helper(TreeNode* root, int cursum, vector<int>& path, int targetSum) {
                //base
                if(root == NULL) {
                    return;
                }
                //logic 
                cursum += root->val;
                path.push_back(root->val);
                if((root->left == NULL) && (root->right == NULL)) {
                    if (cursum == targetSum) {
                        result.push_back(path);
                    }
                }
                helper(root->left, cursum, path, targetSum);
                helper(root->right, cursum, path, targetSum);
                path.pop_back();
                
                return;

        }

 };
