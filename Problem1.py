"""
TC: O(N.H) {we iterate through every element only once and at the leaf node with sum == target, we iterate through height of tree to store the path}
SC: O(N) {The recursive stack memory and the path memory that we pass in the params}

Approach:

We  start the recrusion at the root with curr_sum as 0 and the curr_path as an empty list and iterate through every element.
While iterating, we update the curr_sum at each node and also append the node to its path as well.
Now we check, if we are at a leaf node and the curr_sum == targetSum, then we save the path at that node to our result array.
If not, then we call our recursion on left and right subtree, after this we pop the last element of the path so as to backtrack.

The problem ran successfully on LeetCode.
"""
from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    #this is void based recursion
    def helper(self, node, path, curr_sum):
        if not node:
            return
        
        curr_sum += node.val
        path.append(node.val)

        if not node.left and not node.right and curr_sum == self.target:
            self.res.append(path[:])
        
        self.helper(node.left, path, curr_sum)
        self.helper(node.right, path, curr_sum)

        #backtracking
        path.pop()


    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        self.target = targetSum
        self.helper(root, [], 0)
        return self.res
        