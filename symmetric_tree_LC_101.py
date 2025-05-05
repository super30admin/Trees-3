# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # top-down
    #     self.isValid = True
    #     self.recurse(root.left, root.right)
    #     return self.isValid

    # def recurse(self, leftRoot, rightRoot):
    #     if not leftRoot and not rightRoot:
    #         return
    #     if not leftRoot or not rightRoot or leftRoot.val != rightRoot.val:
    #         self.isValid = False
    #         return 
    #     self.recurse(leftRoot.left, rightRoot.right)
    #     self.recurse(leftRoot.right, rightRoot.left)
    
    # bottom - up 
       
    #     return self.recurse(root.left, root.right)

    # def recurse(self, leftRoot, rightRoot):
    #     if not leftRoot and not rightRoot:
    #         return True
    #     if not leftRoot or not rightRoot or leftRoot.val != rightRoot.val:
    #         return False
         
    #     left = self.recurse(leftRoot.left, rightRoot.right)
    #     right = self.recurse(leftRoot.right, rightRoot.left)
        
    #     return left and right

    #BFS

        que = [(root.left, root.right)]
        while que:
            curr1, curr2 = que.pop(0)
            if not curr1 and not curr2:
                continue
            if not curr1 or not curr2 or curr1.val != curr2.val:
                return False
            que.append((curr1.left, curr2.right))
            que.append((curr2.left, curr1.right))
            
        return True
