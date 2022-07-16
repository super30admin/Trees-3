# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from pip import List
#Time Complexity = O(N)
# Space Complexity = O(N)

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        sum_1 = 0
        results = []
        finalresult = []
        if(root == None):
            return []
               
        def traverse(root: Optional[TreeNode], sum_1: int, results: List[int]):
            if(root is None):
                return
            sum_1 = sum_1 + root.val
            results.append(root.val)
            if(root.left is None and root.right is None):
                if(sum_1 == targetSum):
                    finalresult.append(results.copy())
                results.pop()
                return
            traverse(root.left, sum_1, results)
            traverse(root.right, sum_1, results)
            results.pop()

        traverse(root,sum_1, results)
        return finalresult
        
                    
                    
                
                
        
        