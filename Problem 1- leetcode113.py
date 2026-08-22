#Time Complexity: O(n)
#Space Complexity: O(n) where n is the number of nodes in the tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        self.result = []
        self.helper(root, targetSum, 0, [])
        return self.result

    def helper(self, root, targetSum, currSum, path):
        if root is None:
            return

        currSum += root.val
        path.append(root.val)

        if root.left is None and root.right is None:
            if currSum == targetSum:
                self.result.append(list(path))

        self.helper(root.left, targetSum, currSum, path)
        self.helper(root.right, targetSum, currSum, path)

        path.pop()
        