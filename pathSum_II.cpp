// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes


//Approach 1: mantianing a vector of ints which denotes the path we have traversed till that point 
/*
The vector is passed by value in c++, thus there are no issues in this code
*/

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
    vector<vector<int>> result;
public:
    void recurse(TreeNode* root, int targetSum, int currSum, vector<int> path){
        if(root == NULL)
            return;
        currSum += root->val;
        path.push_back(root->val);
        if(root->left == NULL and root->right == NULL){
            if(currSum == targetSum){
                result.push_back(path);
            }
        }

        recurse(root->left, targetSum, currSum, path);
        recurse(root->right, targetSum, currSum, path);
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(root == NULL) return vector<vector<int>> ();

        //params: root, targetSum, currentSum
        recurse(root, targetSum, 0, vector<int>());
        return result;

    }
};


//If the vector is passed by reference, we would have to re-assign the vector to a new vector at every instance
//or to improve the effeciency of this code, we add backtracking which undoes the action we did (which was to add the root to the path)


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
    vector<vector<int>> result;
public:
    //passing by reference for poc
    void recurse(TreeNode* root, int targetSum, int currSum, vector<int>& path){
        if(root == NULL)
            return;
        currSum += root->val;
        path.push_back(root->val);
        if(root->left == NULL and root->right == NULL){
            if(currSum == targetSum){
                //creating a new vector and assigning the old one to it
                vector<int> temp = path;
                result.push_back(temp);
            }
        }

        //passing the path by reference 
        recurse(root->left, targetSum, currSum, path);
        recurse(root->right, targetSum, currSum, path);

        //backtrqacking i.e., removing the last element while moving from the right to the root node
        path.pop_back();
    }

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(root == NULL) return vector<vector<int>> ();
        vector<int> path;
        //params: root, targetSum, currentSum, path which is a vector of nodes
        recurse(root, targetSum, 0, path);
        return result;

    }
};