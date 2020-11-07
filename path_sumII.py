# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import copy


class Solution(object):
    """
    :type root: TreeNode
    :type sum: int
    :rtype: List[List[int]]
    """

    def rec(self, root, summ, pathlist, pathroot):
        if not root:
            return
        pathlist.append(root.val)

        if summ - root.val == 0 and not root.left and not root.right:
            pathroot.append(copy.deepcopy(pathlist))
            # print(pathroot)
        else:
            self.rec(root.left, summ - root.val, pathlist, pathroot)
            self.rec(root.right, summ - root.val, pathlist, pathroot)
        pathlist.pop()

    def pathSum(self, root, sum):
        pathroot = []
        self.rec(root, sum, [], pathroot)
        return pathroot
    # time-O(n) space-O(height)