#Time Complexity :o(n)
# Space Complexity :o(n)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None: return True
        def dfs_left(root, res):
            if root is None:
                res.append(None)
                return
            res.append(root.val)
            dfs_left(root.left, res)
            dfs_left(root.right, res)
            return res
        def dfs_right(root, res):
            if root is None: 
                res.append(None)
                return
            res.append(root.val)
            dfs_right(root.right, res)
            dfs_right(root.left, res)
            return res
        return dfs_left(root.left, [])==dfs_right(root.right, []) 