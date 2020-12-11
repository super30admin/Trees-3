# Path Sum

# Time Complexity : O(N*N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes with Runtime: 40 ms and Memory Usage: 15.4 MB 
# Any problem you faced while coding this : After Class No
# Your code here along with comments explaining your approach :
# Approach
"""
In Stack, node, sum obtained at a given point and the list of nodes encountered
so far is maintained. Recursive approach is used to solve the problem.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        result = []
        if root:
            self.helper(root, [], result, sum)
        return result
    
    def helper(self, root, newSum, result, sum):
        if root.left==None and root.right==None and root.val == sum:
            newSum.append(root.val)
            result.append([x for x in newSum])
            newSum.pop()
        else:
            newSum.append(root.val)
            if root.left:
                self.helper(root.left, newSum, result, sum-root.val)
            if root.right:
                self.helper(root.right, newSum, result, sum-root.val)
            newSum.pop()
        return