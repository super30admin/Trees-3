# Time complexity: O(n)
# space complexitY: O(n^2)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.targetSum = targetSum
        self.res = []
        self.path(root, 0, [])
        return self.res

    def path(self, root: TreeNode, pathsum: int, node: List[int]):
        if root is None:
            return

        node.append(root.val)
        pathsum = pathsum + root.val

        if root.left is None and root.right is None:
            if pathsum == self.targetSum:
                self.res.append(list(node))


        self.path(root.left, pathsum, list(node))
        self.path(root.right, pathsum, list(node))

