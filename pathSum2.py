"""Approach: Recursion with Backtracking

TC O(N^2) where N are the number of nodes in a tree. In the worst case, we could have a complete binary tree and if that is the case, then there would be N/2
N/2 leafs. For every leaf, we perform a potential O(N) operation of copying over the pathNodes nodes to a new list to be added to the final result
SC O(N) if we don't consider the lists we are building for paths to add to final result. Only consider a path that we use to keep track of nodes so far.
In below example path[:] is copy - and its part of the output - so don't consider it. Only consider path that we passed as parameter to the recursion call.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        self.helper(root, targetSum, 0, [])
        return self.result

    def helper(self,root, target, curr, path):
        # base condition for recursion termination
        if not root: 
            return
        # add curr node value to sum
        curr += root.val
        # add node to list
        path.append(root.val)
        
        # detect leaf node and add to result if sum mataches target
        if not root.left and not root.right:   # leaf node
            if curr == target:
                self.result.append(path[:])   # using path[:] ensures a new independent copy of path is being appended to the result
                # if we don't use copy of path, it may get overwritten
        self.helper(root.left, target, curr, path)
        self.helper(root.right, target, curr, path)
        # backtracking - meaning that if we didn't get desired results, when recursion ends for a branch
        # we remove last value added to the path
        path.pop()