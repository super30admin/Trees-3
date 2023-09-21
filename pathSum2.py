# Time Complexity: O(n^2)
# Space Complexity: O(n^2)

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
        self.res = []
        if root is None:
            return self.res

        def helper(root, sum, path):
            if root is None:
                return

            path.append(root.val)
            helper(root.left, sum+root.val, list(path))
            if root.left == None and root.right == None and sum+root.val == targetSum:
                self.res.append(list(path))
            helper(root.right, sum+root.val, list(path))

        helper(root, 0, [])
        return self.res
