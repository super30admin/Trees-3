"""
 tc: O(n^2) to iterate through n nodes and copy n nodes to form result 
 SP: O(n) to track list of nodes in path
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        def dfs(root, curr, currSum):
            if not root:
                return
            if not root.left and not root.right:
                if currSum+root.val==targetSum:
                    self.result.append(curr+[root.val])
                return
            curr.append(root.val)
            currSum+=root.val
            dfs(root.left, curr[:], currSum)
            dfs(root.right, curr[:], currSum)
        dfs(root, [], 0)
        return self.result