# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Recursively pass root, and list including root value 
# For begining root, [first_root_value]
# dfs - recursive func takes (root, list p)
# Base: if root has no leaf and sum == target: create copy and put in paths; then end this func
# If root has left, pass left as root and list p + left.val
# after this pop and check right side
# If root has right, repeat
# TC - O(n) and SC - O(n)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        paths = []
        if not root:
            return paths
        def dfs(root, p):
            if not root.left and not root.right:
                if sum(p) == targetSum:
                    print(p)
                    paths.append(p.copy())
                return
            if root.left:
                p.append(root.left.val)
                dfs(root.left, p)
                p.pop()
            if root.right:
                p.append(root.right.val)
                dfs(root.right, p)
                p.pop()
            return
        dfs(root, [root.val])
        return paths
            