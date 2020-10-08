"""
Name: Srinidhi 
Did it run on LC: Yes

Time Complexity - O(n)
Space Complexity: O(n) -for the new path created 

Logic: As we do a DFS from root to leaf, keep subtracting value of the node we vsited
When we reach root, check if the remaining sum is equal top root value
and check for root condition.

Maintain a list for path and a list for result.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if root is None:
            return []
        res = []
        
        def dfsHelper(node,path,res,curr):
            if node is None:
                return
            
            path.append(node.val)
            
            
            if curr == node.val and node.left is None and node.right is None:
                res.append(list(path))
            
            else:
                dfsHelper(node.left,path,res,curr-node.val)
                dfsHelper(node.right,path,res,curr-node.val)
            path.pop()
        dfsHelper(root,[],res,sum)
        return res