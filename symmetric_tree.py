# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        #T.C = O(n)
        #S.C = O(h) => height of the tree
        
        #DFS solution: 
        def dfs(left, right):
            if left is None and right is None:
                return True
            
            if not left or not right or left.val != right.val:
                return False
        
            return dfs(left.left, right.right) and dfs(left.right, right.left)
        
        return dfs(root.left, root.right)
    
        
        ####################################################
        #BFS Solution
        
        queue = [root.left, root.right]
        
        while queue:
            
            x, y = queue.pop(), queue.pop()
            if x is None and y is None:
                continue
            if x is None or y is None:
                return False
            if x.val != y.val:
                return False
            queue.append(x.left)
            queue.append(y.right)
            queue.append(x.right)
            queue.append(y.left)
            
        return True
    