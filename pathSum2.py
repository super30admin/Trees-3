"""
Approach: have one single result path that has the path of the nodes that sum to target and add its copy to result. remove elements from
this path while backtracking for resuability of this path.
t.c. = O(n)
s.c. = O(h) where h is the height of the tree
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        path = []

        def helper(root, sums):
            if not root:
                return
            if not root.left and not root.right:
                path.append(root.val)
                sums += root.val
                if sums == targetSum:
                    res.append(path.copy())
                path.pop()
                return 

            path.append(root.val)
            sums += root.val
            helper(root.left, sums)
            helper(root.right, sums)
            path.pop()
            return 
        helper(root, 0)

        return res
        