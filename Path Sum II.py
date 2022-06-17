# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
TC: O(n)
SC: O(n)
"""
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        res= []
        
        def helper(node, currSum, path):
            if not node:
                return
            currSum += node.val
            path.append(node.val)
            if node.left:
                helper(node.left, currSum, path)
                
            if node.right:
                helper(node.right, currSum, path)
            
            if node.left is None and node.right is None:
                if currSum == targetSum :
                    #deep copy is important
                    out = list(path)
                    res.append(out)
            path.pop()
            
            
        helper(root,0,[])
        return res
        
