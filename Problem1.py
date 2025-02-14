#Time complexity O(n)
#Space complexity O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        self.helper(root,[],0,targetSum)
        return self.result

    def helper(self,root: Optional[TreeNode],path: List[int], currSum: int, targetSum: int ):
        
        if(root == None):
            return

        ##logic
        currSum += root.val
        path.append(root.val)
        if(root.left == None and root.right == None):
            if(currSum == targetSum):
                self.result.append(list(path))

        self.helper(root.left,path,currSum,targetSum)
        self.helper(root.right,path,currSum,targetSum)

        path.pop()
        