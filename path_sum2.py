#Time Complexity: O(n)
#Space Complexity: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        path = []
        def helper(root, targetSum, currSum):
            
            if root == None:
                return 
            currSum += root.val
            path.append(root.val)
            
            if root.left == None and root.right == None:
                if targetSum == currSum:
                   
                    newpath = path.copy()
                    res.append(newpath)
                    
            helper(root.left, targetSum, currSum)
            helper(root.right, targetSum, currSum)
            path.pop()

        helper(root, targetSum, 0)
        return res
