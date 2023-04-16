# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
Here we are tracking the path of our traversal in a tree, when we reach a leaf node we check if the sum of the path is 
equal to the target sum, if it is we add the path to the answer list.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.answer = []
        self.path = []
        self.targetSum = targetSum

        self.traverse(root)

        return self.answer

    def traverse(self, root):
        if root == None: return

        self.path.append(root.val)

        if root.right == None and root.left == None:
            if sum(self.path) == self.targetSum:
                self.answer.append(self.path.copy())

        self.traverse(root.left)

        self.traverse(root.right)

        self.path.pop()
