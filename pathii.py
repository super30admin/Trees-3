'''
Time Complexity: O(n)
Space Complexity: O(h)
'''
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
        def inorder(root, arr, sumval, op):
            if(not root): return op
            arr = arr + [root.val]
            if(not root.left and not root.right):
                if(sumval+ root.val == targetSum):
                    op.append(arr)
                return op
            if(root.left):
                op = inorder(root.left, arr, sumval+root.val, op)
            if(root.right):
                op = inorder(root.right, arr, sumval+root.val, op)
            return op
        return inorder(root, [], 0, [])
        