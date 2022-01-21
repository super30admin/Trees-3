'''
TC: O(n)
SC: O(H)

'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        
        def rec(node, target, curr, res):
            
            if not node.left and not node.right:
                if target - node.val == 0:
                    res.append(curr + [node.val])
                return
            
            curr.append(node.val)
            if node.left:
                rec(node.left, target - node.val, curr, res)
            if node.right:
                rec(node.right, target - node.val, curr, res)
            curr.pop()
            
            return
        
        if not root:
            return []
        
        res = list()
        rec(root, targetSum, [], res)
        
        return res
        