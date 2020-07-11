/*
 * Time Complexity : O(N). We are covering each Node once.
 * Space Complexity : Maybe O(n). Because Stack space is required for recursion.
 * Did it run on LeetCode : Yes, a smaller version of the same code ran on LeetCode. 
 */
#include<iostream>
using namespace std;


class Node      // Create a class Node.
{
public:                     // Add Data members and create functions.
    int key;
     Node* left, *right;

     Node *newNode(int key)
    {
        Node *temp = new Node;
        temp->key  = key;
        temp->left  = temp->right = NULL;
        return (temp);
    }


    bool checkMirror(Node *root1,  Node *root2) {      // Function to check if it is a mirror or not.

        if (root1 == NULL && root2 == NULL)     // We use the two pointer approach here.
                                        // For the Binary tree to be mirror, root must be same.
            // So both root pointer start from same root node. One moves towards left subtree and one moves towards right subtree.
            return true;


        if ( root1->key == root2->key)      // If both are same move forward.
            return checkMirror(root1->left, root2->right)// Pointer 1 moves towards the left side. Pointer 2 moves towards the right part.
             &&
                   checkMirror(root1->right, root2->left); // Also, pointer 1 moves towards right and pointer 2 towards left. So this way whole tree is covered.

        return false; // If any one of the above cases fail in recursion, the tree is not a mirror of itself.
    }


};


int main()
{
    Node n1;
    Node *root        = n1.newNode(1);
    root->left        = n1.newNode(2);
    root->right       = n1.newNode(2);
    root->left->left  = n1.newNode(3);
    root->left->right = n1.newNode(4);
    root->right->left  = n1.newNode(4);
    root->right->right = n1.newNode(3);

    cout << n1.checkMirror(root,root); // If it returns 1, then it is mirror. else not a mirror.
    return 0;
}