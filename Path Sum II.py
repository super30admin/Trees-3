# TC - O(n)
# SC - O(h)
# Does this code run on Leetcode: Yes
# Did you find any difficulty while coding this solution: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import copy
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        s = 0
        res = []
        path = []
        def recur(node):
            nonlocal s
            if node == None:
                return 
            path.append(node.val)
            s = s + node.val
            if node.right == None and node.left == None:
                if s == targetSum:       
                    res.append(copy.deepcopy(path))   
            recur(node.left)
            recur(node.right)
            path.pop()
            s = s-node.val        
        recur(root)
        return res
                
        
        
        