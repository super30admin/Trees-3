# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    #Recursive
    def isSymmetric_R(self, root: TreeNode) -> bool:
        
        if not root:
            return True
        
        return self.helper(root,root)
    
    def helper(self,root1,root2):
        
        #Base
        if not root1 and not root2:
            return True
            
        #Logic
        
        if not root1 or not root2:
            return False
        
        return (root1.val==root2.val) and self.helper(root1.left,root2.right) and self.helper(root1.right,root2.left)
    
    #Iterative
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if not root:
            return True
        
        queue = deque()
        
        queue.append(root)
        queue.append(root)
        
        while queue:
            
            r1 = queue.popleft()
            r2 = queue.popleft()
            
            if not r1 and not r2:
                continue
            
            if not r1 or not r2 or (r1.val != r2.val):
                return False
            
            queue.append(r1.left)
            queue.append(r2.right)
            queue.append(r1.right)
            queue.append(r2.left)
        
        return True            
            
            
