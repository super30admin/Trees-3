"""
Leetcode- https://leetcode.com/problems/path-sum-ii/ (submitted)
TC - omg(N) - considering average case, deep copy is only numbered to desired outcome, SC- O(N) - maintaining path
Lecture- https://www.youtube.com/watch?v=JW2KxAHFqv8
FAQ-
What will happen if you don't deep copy the path? Passing list in recursion is by reference, which means each node will
share the same list path. *Refer lecture*
preorder/postorder/inorder - wouldn't matter which traversal you use since all will be visiting each node which we want.
Only thing we will be giving attention to is that the currSum and path should be added when that node instance is
executing, i.e., done before calling recursive calls.


Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values
in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: []

Example 3:
Input: root = [1,2], targetSum = 0
Output: []


Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    # defining result as private to this class
    result = []

    def pathSum(self, root, targetSum):
        if root is None:
            return []
        self.helper(root, 0, [], targetSum)
        return self.result

    '''
    Ideation - 
    Brute force recursion - Explore all the paths and check if the sum of path is equal to target sum, store the path. 
    '''
    # TC - O(N^2) - each node * deep copy of path, O(N) - maintaining path
    def helper1(self, root, curSum, path, targetSum):
        if root is None:
            return None

        curSum += root.val
        path.append(root.val)
        # check if we reached leaf node and have path sum desired.
        if curSum == targetSum and root.left is None and root.right is None:
            self.result.append(path)

        #  deep copy path - so each instance of node has its own path and not shared by reference
        self.helper(root.left, curSum, path[:], targetSum)
        self.helper(root.right, curSum, path[:], targetSum)

    '''
    Ideation - 
    Backtracking - Instead of passing fresh references of path for each recursive call, we reset our state of variable
    to be back to how they were. Doing so will let us use the same path instance instead of making individual references
    for each node. (reducing the TC of deep copy from O(N^2) to O(N))
    '''
    # TC - omg(N) - considering average case, deep copy is only numbered to desired outcome, SC- O(N) - maintaining path
    def helper(self, root, curSum, path, targetSum):
        if root is None:
            return None

        curSum += root.val
        path.append(root.val)
        # check if we reached leaf node and have path sum desired.
        if curSum == targetSum and root.left is None and root.right is None:
            # deep copy of path is stored in our result since we are using the same reference of path and will lose this
            # state later.
            self.result.append(path[:])

        #  deep copy path - so each instance of node has its own path and not shared by reference
        self.helper(root.left, curSum, path[:], targetSum)
        self.helper(root.right, curSum, path[:], targetSum)

        #backtrack
        path.pop()
