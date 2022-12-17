//Time Complexity O(N) , N is the number of nodes on the tree
// Space Complexity O(N) , N is the maximum possible size of the queue

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
 // Use bfs to solve this problem
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        // step 1 to create a queue
        if(root == NULL){
            return true ; 
        }
        queue<TreeNode*> bfs; 
        bfs.push(root -> left) ; 
        bfs.push(root -> right) ; 
        //cout << bfs.front() ; 
        //cout << bfs.size() ; 
        while(!bfs.empty()){
            TreeNode *left = bfs.front() ; 
            bfs.pop() ; 
            TreeNode *right = bfs.front() ;
            bfs.pop() ; 

            if(left == NULL && right == NULL ) continue ; 

            if(left == NULL || right == NULL || left ->val!= right -> val){
                return false ; 
            }

            bfs.push(left->left) ; 
            bfs.push(right -> right) ; 
            bfs.push(left -> right) ; 
            bfs.push (right -> left) ; 
        }

        return true ; 
    }

} ; 
