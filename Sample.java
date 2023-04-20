# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        path = []
        self.dfs(root, targetSum, path, result)
        return result

    def dfs(self, node, target, path, result):
        if not node:
            return
        path.append(node.val)
        if not node.left and not node.right and node.val == target:
            result.append(path[:])
        self.dfs(node.left, target - node.val, path, result)
        self.dfs(node.right, target - node.val, path, result)
        path.pop()

## Symmetric Tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        return self.isMirror(root.left, root.right)
    
    def isMirror(self, node1: TreeNode, node2: TreeNode) -> bool:
        if not node1 and not node2:
            return True
        if not node1 or not node2:
            return False
        if node1.val != node2.val:
            return False
        return self.isMirror(node1.left, node2.right) and self.isMirror(node1.right, node2.left)