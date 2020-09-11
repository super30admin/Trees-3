"""
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Time = O(n), n = number of nodes in a tree
Space = O(n), n = number of nodes in a tree
Successfully excecuted on leetcode

Approach ---
1. Recursive solution starting from root value till leaf
2. Parameters for recursive function - 
    a. root - root value(update at each function for left/right child)
    b. sum - target value given(update at each child with (sum-(curren root value))
    c. currpath - when the path sum is equal to target given
    d. res - list of currpaths
2. when we reach leaf node if remaining sum == current root, append to currpath

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class PathSum3:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if not root:
            return []
        res = []
        currpath = []
        self.dfs(root, sum, currpath, res)
        return res

    def helper(self, root, sum, currpath, res):
        if not root.left and not root.right and sum == root.val:
            currpath.append(root.val)
            res.append(currpath)
        if root.left:
            self.helper(root.left, sum-root.val, currpath+[root.val], res)
        if root.right:
            self.helper(root.right, sum-root.val, currpath+[root.val], res)