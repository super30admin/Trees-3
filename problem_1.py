# Time Complexity - O(n)
# Space Complexity - O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        currSum = 0
        self.result = []
        path = []
        self.helper(root,0,targetSum,path)
        return self.result

    def helper(self,root,currSum,targetSum,path):

        if not root: 
            return None

        path.append(root.val)
        
        currSum = currSum + root.val 
        if not root.left and not root.right and currSum == targetSum : 
            self.result.append(path.copy())

        
       

        self.helper(root.left,currSum,targetSum,path)
        self.helper(root.right,currSum,targetSum,path)

        path.pop()

        return self.result

        

