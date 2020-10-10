"""
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
"""
SImply traverse through every node and increase the sum.
If we reach the sum and doesnt have any children we can add that path to paths.
"""
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        # Run time complexity: O(N)
        # Space Complexity: O(N)
        paths = []
        self.sum  = sum
        self.find(root, 0, [], paths)
        return paths
        
    def find(self, head, summ, path, paths ):
        if not head:
            return 
        if head.val+summ == self.sum and  not head.left and not head.right :
            path = path+[head.val]
            paths.append(path)
            return
        else:
            path = path+[head.val]
            self.find(head.left, head.val+summ, path, paths)
            self.find(head.right, head.val+summ, path, paths)
        
        
        