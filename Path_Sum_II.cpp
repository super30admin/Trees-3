// main.cpp
// 113_Path_Sum_II

/* Approach:  Iterative Peorder tarversal, push pair of node and vector of processes elements. 
   Once we reach child node, extract the list corresponding to child node, 
   calculate the sum and check if it is equal to target. If so, add it to result.*/
   
// TC: O(N), N - number of nodes in a tree
// SC: O(h+N) - height of the tree, N - number of nodes in a tree

#include <iostream>
#include <vector>
#include <stack>
#include <numeric>

using namespace std;

//Definition for a binary tree node.

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Pair{
private:
    TreeNode* node;
    vector<int> v;
    
public:
    Pair(TreeNode* node, vector<int> v){
        this->node = node;
        this->v=v;
    }
    
    TreeNode* getNode(){
        return node;
    }
    
    vector<int> getValues(){
        return v;
    }
};


class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        if(root == NULL)
            return vector<vector<int>>();
        stack<Pair> s;
        vector<int> temp;
        vector<vector<int>> result;
        while(root!=NULL || s.empty()==false){
            while(root!=NULL){
                temp.push_back(root->val);
                Pair obj(root,temp);
                s.push(obj);
                root=root->left;
            }
            Pair obj = s.top(); s.pop();
            root = obj.getNode();
            temp = obj.getValues();
            if(root->left == NULL && root->right == NULL){
                if(accumulate(temp.begin(),temp.end(),0) == sum) result.push_back(temp);
            }
            root = root->right;
        }
        return result;
    }
};





int main(int argc, const char * argv[]) {
    TreeNode* node = new TreeNode(1);
    node->left = new TreeNode(2);
    Solution s;
   // s.sumNumbers(node);
    vector<vector<int>> v =  s.pathSum(node,1);
    for(vector<int> i:v){
       for(int j:i)
           cout<<j<<"\t";
       cout<<endl;
    }
    return 0;
}
