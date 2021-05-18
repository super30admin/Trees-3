class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    result = []

    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None: return
        self.ischeck(root)
        print(self.result)
        left, right = 0, len(self.result) - 1
        while (left <= right):
            if self.result[left] != self.result[right]: return False
            left += 1
            right -= 1
        return True

    def ischeck(self, root: TreeNode) -> None:
        if root is None: return
        self.ischeck(root=root.left)
        self.result.append(root.val)
        self.ischeck(root=root.right)


        # space=O(n)
        # time:-O(n)