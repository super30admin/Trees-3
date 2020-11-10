//
// Created by shazm on 7/24/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

// Runtime: O(N)
// Space: O(N)
// Algorithm: go to every root-leaf and do target-node.val at every level till leaf. If leaf.val == required target, then add to vector else return.
// Do that for every possible value and add to vector.
// Works on leetcode : yes

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> retVec; vector<int> currentVec;
        recurr(root,sum,retVec,currentVec);

        return retVec;

    }

    void recurr(TreeNode* node, int targetsum, vector<vector<int>>& vec, vector<int>& currentVec){
        if(node == NULL){
            return;
        }
        if(node->left == NULL && node->right == NULL){
            if(node->val == targetsum){
                currentVec.push_back(node->val);
                vec.push_back(currentVec);
            }
            return;
        }

        currentVec.push_back(node->val);
        vector<int> temp = currentVec;

        int newSum = targetsum - node->val;

        recurr(node->left, newSum, vec, currentVec);
        currentVec = temp;
        recurr(node->right, newSum, vec, currentVec);
        currentVec = temp;

        return;
    }
};

int main(){
    Solution s;

    return 0;
}