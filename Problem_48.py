# TC: O(n2)
# SC: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def helper(root, curNum, list1, targetSum):
            if root == None:
                return
            curNum = curNum + root.val
            list1.append(root.val)

            # PREORDER TRAVERSAL
            if root.left is None and root.right is None:
                if curNum == targetSum:
                    self.res.append(list(list1))
            
            helper(root.left, curNum, list1, targetSum)

            helper(root.right, curNum, list1, targetSum)

            # backtrack
            list1.pop()

        self.res = []
        helper(root, 0, [], targetSum)
        return self.res