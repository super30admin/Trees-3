# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root, targetSum: int):
        self.res = []
        if root == None:
            return self.res

        def recursion(root, sum, arr):
            if root == None:
                return

            arr.append(root.val)
            recursion(root.left, sum+root.val, list(arr))
            if root.left == None and root.right == None and sum+root.val == targetSum:
                self.res.append(list(arr))
            recursion(root.right, sum+root.val, list(arr))
            #arr.remove(arr[-1])
        
        recursion(root, 0, [])
        return self.res

#TC: O(n**2)
#SC: O(n**2)