// Approach 1 - passing my 'path' vector by value instead by reference.
// Time Complexity - O(n)
// Space Complexity - O(h)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> answer;
    private:
    void helper(TreeNode* root, vector<int> path, int curr, int target){
        // base
        if(!root) return;
        // logic
        curr += root->val;
        path.push_back(root->val);
        
        helper(root->left, path, curr, target);
        
        if(!root->left && !root->right){
            if(curr == target)
                answer.push_back(path);
        }
        helper(root->right, path, curr, target);
    }
    
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(!root) return answer;
        vector<int> path;
        helper(root, path, 0, targetSum);
        return answer;
    }
};


// Approach 2 - Creating a deepcopy of my 'path' vector at every node.
// Time Complexity - O(n*h)
// Space Complexity - O(n*h)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> answer;
    private:
    void helper(TreeNode* root, vector<int>& path, int curr, int target){
        // base
        if(!root) return;
        // logic
        curr += root->val;
        path.push_back(root->val);
        
        vector<int> pathCopy(path);
        helper(root->left, pathCopy, curr, target);
        
        if(!root->left && !root->right){
            if(curr == target)
                answer.push_back(path);
        }
        vector<int> pathCopy2(path);
        helper(root->right, pathCopy2, curr, target);
    }
    
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(!root) return answer;
        vector<int> path;
        helper(root, path, 0, targetSum);
        return answer;
    }
};

// Backtracking approach
// Time Complexity - O(n) - Since we are traversing all the 'n' nodes in the input tree.
// Space Complexity - O(h)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> paths;
    private:
    void helper(TreeNode* root, vector<int>& path, int curr, int target){
        // base
        if(!root) return;
        
        // logic
        curr += root->val;
        
        // action
        path.push_back(root->val);
        
        // recurse
        // left
        helper(root->left, path, curr, target);
        
        if(!root->left && !root->right){
            if(curr == target)
                paths.push_back(path);
        }
        
        //right
        helper(root->right, path, curr, target);
        
        //backtracking
        path.pop_back();
        
        // if(curr > target) return;   // we can have negative values so this can't be done.
    }
    
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(!root) return paths;
        vector<int> path;
        helper(root, path, 0, targetSum);
        return paths;
    }
};