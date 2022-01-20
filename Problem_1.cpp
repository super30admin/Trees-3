/*
Time Complexity:
O(N) as we are now just doing the traversal of the tree and not
copying the path at each node. In our backtracking solution
the copying part is eliminated. So, the TC is reduced to O(N)
*/

/*
Space Complexity:
O(H) where H is the height of tree. 
*/

/*
Approach:
We followed two techniques - 
first, normal recursion which involved copying of the
path at each node making the TC O(N^2).
second, backtracking with recursion eliminating the 
copying part and reducing the TC to O(N).

The intution here is that we have to traverse the 
tree and maintain a running sum in which we keep on
adding the value of the current node and when this
running sum becomes equal to our target we get our path
and add it to the result.

In the first apppproach, there was overhead of copying.
So we tried backtacking and we observed that if
we are removing the last element from the current path
and the current path as new vector in the resultant
vector when we hit the target we wil get our reesult
in optimized time.
*/

// The code ran perfectly on leetcode





class Solution {
    
    vector<vector<int>> result;
    int target;
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        target= targetSum;
        vector<int> path;
        helper(root, 0, path);
        return result;
    }
    
    private:
    void helper(TreeNode* root, int runSum, vector<int> path){
        //base
        if(root== NULL) return;
        //logic
        runSum += root->val;
        path.push_back(root->val);
        if(root->left == NULL && root->right == NULL){
            if(runSum == target){
                result.push_back(vector<int> ({path}));
            }
        }
        helper(root->left, runSum, path);
        helper(root->right, runSum, path);
        path.pop_back();
    }
};