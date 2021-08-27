# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Recursive appraoch
    TC - O(n)
    SC - O(h)
    """

    def appraoch1(self, left, right):
        if left == None and right == None:
            return True
        if left == None or right == None or left.val != right.val:
            return False
        return self.appraoch1(left.left, right.right) and self.appraoch1(left.right, right.left)

    """
    Iterative approach
    TC - O(n)
    SC - O(n)
    """

    def approach2(self, root):
        stack = [root.left, root.right]
        while len(stack) > 0:
            left = stack.pop()
            right = stack.pop()
            if left == None and right == None:
                continue
            if left == None or right == None or left.val != right.val:
                return False
            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)
        return True

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        # return self.appraoch1(root.left,root.right)
        return self.approach2(root)
