"""
Intuition: Store the path till the node in each node
#####################################################################
Time Complexity : O(N) 
Space Complexity : O(H)
#####################################################################
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        result = []
        self.pathSumHelper(root, [], 0, result, targetSum)
        return result
    
    def pathSumHelper(self, node, partialPath, partialSum, result, targetSum):
        
        if node is None:
            return
        
        totalPath = partialPath + [node.val]
        totalSum = partialSum + node.val
        
        if node.left is None and node.right is None:
            if targetSum == totalSum:
                result.append(totalPath)
        self.pathSumHelper(node.left, totalPath, totalSum, result, targetSum)
        self.pathSumHelper(node.right, totalPath, totalSum, result, targetSum)
            