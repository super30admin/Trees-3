# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = []

    def getPath(self, root, path, targetSum):
        if not root:
            return

        path.append(root.val)
        self.getPath(root.left, path, targetSum)

        if not root.left and not root.right:

            if sum(path) == targetSum:
                self.result.append(list(path))

        self.getPath(root.right, path, targetSum)
        path.pop()

    def pathSum(self, root, targetSum):
        self.result = []
        if not root:
            return []

        self.getPath(root, [], targetSum)

        return self.result




