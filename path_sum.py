'''
TC:O(N^2)
SC:O(N)
'''

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: TreeNode, summation: int):
        results = []
        stack = [([], root)]
        while stack:
            result, node = stack.pop()
            if not node:
                continue
            if node.left is node.right and sum(result + [node.val]) == summation:
                results.append(result + [node.val])
                continue
            node.left and stack.append((result + [node.val], node.left))
            node.right and stack.append((result + [node.val], node.right))
        return results