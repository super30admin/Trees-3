
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    final = []
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        def helper(root, adder, output):
            # Base
            if not root: return
            # Logic
            adder += root.val
            output.append(root.val)
            if not root.left and not root.right:
                if adder == targetSum:
                    self.final.append(output)
                    # print(adder, output, self.final)
            helper(root.left, adder, output)
            helper(root.right, adder, output)
            output.pop()

        helper(root, 0, [])
        return self.final