# Time Complexity :O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         
        if not root: 
            return []
        final = []
        def dfs(root, nodes, total):
            if root.val == total and not root.left and not root.right:
                final.append(nodes[:] + [root.val])
            if root.right:
                dfs(root.right, nodes + [root.val], total - root.val)
            if root.left: 
                dfs(root.left, nodes + [root.val] ,total - root.val)      
        dfs(root, [], finaltotal)
        return final