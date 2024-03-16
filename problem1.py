# https://leetcode.com/problems/path-sum-ii/

# Time Complexity : O(N) is Number of nodes in the tree.
# Space Complexity : O(H) where H is height of the tree, and stack space is used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach.
# Approach - We do DFS on the tree and keep adding the root val into the cur list. If we reach a leaf node.
# We copy cur list into a new list and add the leaf node value and check if the total is equal to target.
# if Yes, we copy it into the result. Else we skip it.

from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    result: []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        self.result = []
        self.find_paths(root, targetSum, [])
        return self.result

    def find_paths(self, root, target, cur_path: []):
        if root is None:
            return

        if root.left is None and root.right is None:
            temp = cur_path.copy()
            temp.append(root.val)
            if target == sum(temp):
                self.result.append(temp)
            return

        cur_path.append(root.val)
        self.find_paths(root.left, target, cur_path)
        self.find_paths(root.right, target, cur_path)
        cur_path.pop()
