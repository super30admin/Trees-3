"""
Implemented with reference to the homework solution.
Time Complexity: O(n^2)
Space Complexity: O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        
        self.result = []
        self.dfs(root, [root.val], root.val, targetSum)
        return self.result

    def dfs(self, node: TreeNode, path: List[int], curr_sum: int, target: int):
        if not node.left and not node.right and curr_sum == target:
            self.result.append(path)
            return

        if node.left:
            self.dfs(node.left, path + [node.left.val], curr_sum + node.left.val, target)
        
        if node.right:
            self.dfs(node.right, path + [node.right.val], curr_sum + node.right.val, target)

        