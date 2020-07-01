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
//BFS solution
// Time Complexity : O(n) +O(n) //Once for iterating and once for checking the stored value array
// Space Complexity : O(n) worst case O(n/2). //For both queue and the x=created vector for temp_result
//1. Find root and store left or right root in the queue.
//2. Push the left path elements and then right in the queue till the level is completed.
//3. Compared the stored elements at all the levels for symmetricity.
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        //edge cae
        if(root ==NULL){
            return true;
        }
        queue<TreeNode *> myqueue;
        myqueue.push(root);
        int size,temp_size;
        while(!myqueue.empty()){
            size = myqueue.size();
            vector<int> temp_array;
            //level traversal
            while(size>0){
                    TreeNode* temp = myqueue.front();
                    myqueue.pop();
                    size--;
                    if(temp == NULL) {
                        temp_array.push_back(-999);
                        continue;
                    }
                    temp_array.push_back(temp->val);
                    myqueue.push(temp->left);
                    myqueue.push(temp->right);
                }
            temp_size = temp_array.size();
            for(int k=0; k<temp_size; k++){
                if(temp_array[k] !=  temp_array[temp_size-k-1]) return false;
            }
        }
        return true;
    }
};

//Recursive solution
// Time Complexity : O(n)
// Space Complexity : O(h) worst case O(n).
//1. Traversal takes place along two paths towards lhs->left , rhs->right and then lhs->right, rhs->left
//2. Check is made to see the values at each level are same
//3. if not return false

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        //edge cae
        if(root ==NULL){
            return true;
        }
        return helper (root->left, root->right);
        
    }
private:
    bool helper(TreeNode* lhs, TreeNode* rhs){
        //base
        if(lhs == NULL && rhs == NULL){
            return true;
        }
        if(lhs ==NULL || rhs==NULL|| lhs->val != rhs->val){
            return false;
        }
        //logic
        return helper(lhs->left, rhs->right) &&  helper(lhs->right, rhs->left);
    }
};
