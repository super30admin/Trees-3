# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import copy
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        self.res = []
        
        def paths(root, total, path):
            
            if not root:
                return
            path.append(root.val)

            if not root.left and not root.right:
                t = root.val + total
                if t == targetSum:
                    newPath = copy.deepcopy(path)
                    self.res.append(newPath)
            
            paths(root.left, total + root.val, path)
            paths(root.right, total + root.val, path)

            # backtracking (more efficient as we just have to use a single list and not create a separate list at each node)
            path.pop()
            
            
        paths(root, 0, list())
        return self.res
