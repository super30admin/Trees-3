#
# Time Complexity  = O(n)
# Space Complexity  = O(h) recursive stack space
#


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        def dfs(curr, path, s):
            path = path+[curr.val]
            s += curr.val
            if not curr.left and not curr.right:
                if s == sum:
                    ans.append(path)
                return
            if curr.left:
                dfs(curr.left, path.copy(), s)
            if curr.right:
                dfs(curr.right, path.copy(), s)
                
        if not root:
            return []
        ans = []
        dfs(root, [], 0)
        return ans
