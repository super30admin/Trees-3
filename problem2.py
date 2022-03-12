# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

TC: O(n)
SC: O(h)

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return False

        if root.left is None and root.right is None:
            return True

        return self.dfs(root.left,root.right)

    def dfs(self,left,right):
        # base case
        # print("Left : ",left)
        # print("Right :" ,right)
        if left is None and right is None:
            return True

        if left is None or right is None:
            return False

        # print(" ")

        if left.left is None and left.right is None and right.left is None and right.right is None:
            if left.val == right.val:
                return True

        #logic
        if left.val != right.val:
            return False
        else:
            if self.dfs(left.right,right.left) and self.dfs(left.left,right.right):
                return True

        return False



