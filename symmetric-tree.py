"""
Time - O(n)
Space - O(h)
"""
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def dfs(left, right):
            #base case
            if left == None and right == None:
                return True
            
            #logic
            if left is None or right is None or \
                left.val != right.val:
                return False
            
            return dfs(left.left, right.right) and dfs(left.right, right.left)


        if root == None : return True
        return dfs(root.left, root.right)


        