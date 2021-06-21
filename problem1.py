# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        self.result = []
        
        def helper(root, currSum, path):
            #Base case
            if root == None: return 
            
            #Action performed
            path.append(root.val)
            currSum += root.val
            
            #Driver code - Recursion Calls
            helper(root.left, currSum, path)
            #stack.pop() after left rec call is complete
            helper(root.right, currSum, path)
            #stack.pop() after right rec call is complete
            
            #After both calls we can check if they are root nodes and sum until here equals out targetSum.
            if root.left == None and root.right == None:
                if targetSum == currSum:
                    self.result.append(path.copy())
            
            #Backtracking
            path.pop()
            
        helper(root, 0, [])
        return self.result
        
#Time complexity is O(n) space complexity O(h)
#Approach: checking the sum at each leaf node and if it matches append a copy of path to result array