# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None: return True
        def dfs_left(root, num):
            if root is None:
                num.append(None)
                return
            num.append(root.val)
            dfs_left(root.left, num)
            dfs_left(root.right, num)
            return num
        def dfs_right(root, num):
            if root is None: 
                num.append(None)
                return
            num.append(root.val)
            dfs_right(root.right, num)
            dfs_right(root.left, num)
            return num
        return (dfs_left(root.left, [])) == (dfs_right(root.right, [])) 