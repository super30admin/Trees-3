# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        self.res = []

        def pathSumNodes(root, currSum, path):
            if not root:
                return
            currSum += root.val
            path.append(root.val)
            if not root.left and not root.right and currSum == targetSum:
                self.res.append([] + path)

            pathSumNodes(root.left, currSum, path)
            pathSumNodes(root.right, currSum, path)
            path.pop()

        pathSumNodes(root, 0, [])
        return self.res

