# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)

This problem is an extension to the path sum problem as here we have to store the current path as well. We will traverse the tree recursively and maintain the sum and current path of the nodes. When leaf is reached we will check if the running sum is equal to the target or not if it is then we will the path to the result list. After exploring both subtrees left one and right one we will remove the current node from the path to backtrack correctly.



## Problem2 (https://leetcode.com/problems/symmetric-tree/)

In this approach we will check if the left and right subtrees of the root are mirror images of each other by recursively comparing nodes. The base case will be returning true if both nodes are null and false if one is null or their values do not match. We also need to ensure that left's left subtree matches with right's right subtree and left's right subtree matches with right's left subtree. 